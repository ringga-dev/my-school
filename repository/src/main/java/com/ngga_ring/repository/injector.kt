package com.ngga_ring.repository

import androidx.room.Room
import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.gsonpref.gson
import com.google.gson.Gson
import com.ngga_ring.repository.common.Constant
import com.ngga_ring.repository.repository.local.AppDatabase
import com.ngga_ring.repository.repository.local.AuthPrefs
import com.ngga_ring.repository.repository.remote.network.getOkHttp
import com.ngga_ring.repository.repository.remote.network.getService
import com.ngga_ring.repository.repository.remote.service.AuthService
import com.ngga_ring.repository.repository.remote.service.ProductService
import com.ngga_ring.repository.repository.AuthRepository
import com.ngga_ring.repository.repository.ProductRepository
import com.ngga_ring.repository.repository.StoreRepository
import com.ngga_ring.repository.repository.local.LoginPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    Kotpref.gson = Gson()

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, Constant.DB_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    single { AuthPrefs }
    single { LoginPrefs }

    single { getOkHttp(androidContext()) }
    single { getService<ProductService>(get()) }
    single { getService<AuthService>(get()) }

    single { ProductRepository(get(), get(), get()) }
    single { StoreRepository(get(), get()) }
    single { AuthRepository(get(), get(), get(), get()) }
}