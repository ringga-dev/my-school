package com.ngga_ring.myschool


import com.ngga_ring.myschool.activity.storelogin.StoreViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { CashierProductViewModel(get(), get()) }
//    viewModel { ProductViewModel() }
//    viewModel { LoginViewModel(get()) }
    viewModel { StoreViewModel(get(), get()) }
}