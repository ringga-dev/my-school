package com.zenwel.pos.di

import android.annotation.SuppressLint
import android.app.Application
import android.provider.Settings
import androidx.room.Room
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.zenwel.pos.AppExecutors
import com.zenwel.pos.BuildConfig
import com.zenwel.pos.api.ApiService
import com.zenwel.pos.database.ZenwelDb
import com.zenwel.pos.utils.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [DaoModule::class, RepositoryModule::class])
@InstallIn(ApplicationComponent::class)
class AppModule {

    companion object {
        /********
         * URLS
         */
        private val LOCAL = Vars.getLocale()
        private val ROOT_URL = "${BuildConfig.SERVER_URL}/api/admin/v1/${LOCAL}/"
        //private val ROOT_URL = "${BuildConfig.URL_STAGING}/api/admin/v1/${LOCAL}/"
    }

    @SuppressLint("HardwareIds")
    @Singleton
    @Provides
    fun provideApiService(app: Application): ApiService {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->

            try {
                val original = chain.request()
                val request = original.newBuilder()
                    .header("Content-Type", "application/json")
                    .header("device", Settings.Secure.getString(app.contentResolver, Settings.Secure.ANDROID_ID))
                    .header("app_version", "${BuildConfig.VERSION_CODE}")
                    .method(original.method(), original.body())
                    .build()

                chain.proceed(request)
                /*val process = chain.proceed(request)

                // if 401 do Logout
                Timber.d("provideApiService ${process.code()} ${process.request().url()} ${app.getDeviceCheckedPref()}")
                if (process.code() == 401
                        && !process.request().url().toString().contains("newDevice/checkDevicePair")
                        && !process.request().url().toString().contains("oauth/getLoc")
                        && !process.request().url().toString().contains("ignore_unauthorized_check=true")
                ) {
                    app.putPref(Vars.PREF_AUTH, Vars.PREF_AUTH_KEY, Auth())
                    app.putPref(Vars.PREF_LOCATION, Vars.PREF_LOCATION_KEY, Location())
                    app.putPref(Vars.PREF_STAFF, Vars.PREF_STAFF_KEY, Staff())
                    app.putPref(Vars.PREF_CURRENT_DEVICE_CHECK, Vars.PREF_CURRENT_DEVICE_CHECK_KEY, false)
                    val intent = Intent(app, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    app.startActivity(intent)
                }

                return@addInterceptor process*/
            } catch (exception: Exception) {
                exception.printStackTrace()
                abortRequest(chain.request())
            }
        }.retryOnConnectionFailure(true)
                .connectTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            val logInterceptor = HttpLoggingInterceptor()
            //logInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
            logInterceptor.level = HttpLoggingInterceptor.Level.BODY

            httpClient.addInterceptor(logInterceptor)
            httpClient.addInterceptor(ChuckerInterceptor(app))
        }

        val client = httpClient.build()

        client.dispatcher().maxRequests = 20

        return Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }

    private fun abortRequest(request: Request): Response {
        return Response.Builder()
            .code(500) //Simply put whatever value you want to designate to aborted request.
            .protocol(Protocol.HTTP_2)
            .message("Connection Error, Aborting request.")
            .body(ResponseBody.create(MediaType.parse("text/html; charset=utf-8"), ""))
            .request(request)
            .build()
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): ZenwelDb {
        return Room
            .databaseBuilder(app, ZenwelDb::class.java, "zenwel.db")
                .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideAppExecutor(): AppExecutors = AppExecutors()

}