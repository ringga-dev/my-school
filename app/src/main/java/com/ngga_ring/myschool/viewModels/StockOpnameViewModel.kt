package com.zenwel.pos.ui.viewmodels

import androidx.databinding.Bindable
import androidx.databinding.ObservableBoolean
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.zenwel.pos.BR
import com.zenwel.pos.models.*
import com.zenwel.pos.repositories.*
import com.zenwel.pos.utils.*
import com.zenwel.pos.vo.Resource
import kotlin.toString

class StockOpnameViewModel
@ViewModelInject constructor(
    private val stockOpnameRepository: StockOpnameRepository,
    private val locationsRepository: LocationsRepository,
    private val companyRepository: CompanyRepository
) : ObservableViewModel() {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String>
        get() = _token

    // ---- Data Binding Variables ----
    var location: Location? = null
    val isLoading = ObservableBoolean(false)
    val hasFilter = ObservableBoolean(false)
    var _searchText = ""
    var selectedLocationId = 0

    @Bindable
    var searchText = ""
        set(value) {
            if (field != value) {
                field = value
                if (field.isEmpty() && field != _searchText) refresh()
                notifyPropertyChanged(BR.searchText)
            }
        }

    @Bindable
    var locationText = ""
        set(value) {
            if (field != value) {
                field = value
                notifyPropertyChanged(BR.locationText)
            }
        }

    fun setAuth(token: String?) {
        if (_token.value != token) {
            _token.value = token.toString()
        }
    }

    fun refresh() {
        _token.value?.let {
            _token.value = it
        }
    }

    val locations: LiveData<Resource<List<Location>>> = Transformations
        .switchMap(_token) { token ->
            if (token == null) {
                AbsentLiveData.create()
            } else {
                if (InternetUtil.isInternetOn()) {
                    locationsRepository.getLocations(token)
                } else {
                    DisconnectedLiveData.create()
                }
            }
        }

    fun getStockOpnameList(filterParams: HashMap<String,String>, page: Int = 1) =
        Transformations.switchMap(_token) { token ->
            if (token == null) {
                AbsentLiveData.create()
            } else {
                if (InternetUtil.isInternetOn()) {
                    _searchText = searchText
                    val params = ParamsBuilder(filterParams)
                        .apply { if (searchText.isNotEmpty()) setSearchParam("name", conditions = "and", value = searchText) }
                        .buildParams().also {
                            it["location_id"] = selectedLocationId.toString()
                            it["page"] = page.toString()
                        }
                    stockOpnameRepository.getStockOpname(token, params)
                } else {
                    DisconnectedLiveData.create()
                }
            }
        }

    val company: LiveData<Resource<Company>> = Transformations
        .switchMap(_token) { token ->
            if (token == null) {
                AbsentLiveData.create()
            } else {
                if (InternetUtil.isInternetOn())
                    companyRepository.getCompany(token)
                else
                    DisconnectedLiveData.create()
            }
        }



    fun getProductStockOpName(params: HashMap<String, String>) =
        Transformations.switchMap(_token) { token ->
            if (token == null) {
                AbsentLiveData.create()
            } else {
                if (InternetUtil.isInternetOn()) {
                    val param = ParamsBuilder(params)
                        .apply {
                            if (searchText.isNotEmpty()) {
                                setSearchParam("name", null, searchText)
                                setSearchParam("barcode","=",  "OR",searchText)
                            }
                        }.buildParams()
                    stockOpnameRepository.getProductStockOpName(token,param)
                } else {
                    DisconnectedLiveData.create()
                }
            }
    }

    fun getHeadProductStockOpName(stockOpnameId: Int) = Transformations.switchMap(_token) { token ->
        if (token == null) {
            AbsentLiveData.create()
        } else {
            if (InternetUtil.isInternetOn()) {
                stockOpnameRepository.getHeadProductStockOpName(token, stockOpnameId)
            } else {
                DisconnectedLiveData.create()
            }
        }
    }

    fun createStockOpName(token: String?) =
        if (token == null) {
            AbsentLiveData.create()
        } else {
            if (InternetUtil.isInternetOn()) {
                val body = ParamsBuilder().buildBody {
                    it.addFormDataPart("location_id",selectedLocationId.toString())
                }
                stockOpnameRepository.createStockOpName(token, body)
            } else {
                DisconnectedLiveData.create()
            }
        }


    fun updateStockOpname(
        token: String?,
        stockOpanemId: Int,
        params: ((param: HashMap<String, String>) -> Unit)? = null
    ) =
        if (token == null) {
            AbsentLiveData.create()
        } else {
            if (InternetUtil.isInternetOn()) {
                val param = HashMap<String, String>()
                params?.invoke(param)
                stockOpnameRepository.updateStockOpname(token, stockOpanemId, param)
            } else {
                DisconnectedLiveData.create()
            }
        }



}