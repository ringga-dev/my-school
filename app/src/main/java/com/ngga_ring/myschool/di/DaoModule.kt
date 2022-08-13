package com.zenwel.pos.di

import com.zenwel.pos.database.ZenwelDb
import com.zenwel.pos.database.dao.*
import com.zenwel.pos.models.PermissionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class DaoModule {

    @Singleton
    @Provides
    fun provideClosedDateDao(db: ZenwelDb): ClosedDateDao {
        return db.closedDateDao()
    }

    @Singleton
    @Provides
    fun provideLocationDao(db: ZenwelDb): LocationDao {
        return db.locationDao()
    }

    @Singleton
    @Provides
    fun provideBusinessTypeDao(db: ZenwelDb): BusinessTypeDao {
        return db.businessTypeDao()
    }

    @Singleton
    @Provides
    fun provideCityDao(db: ZenwelDb): CityDao {
        return db.cityDao()
    }

    @Singleton
    @Provides
    fun provideCompanyDao(db: ZenwelDb): CompanyDao {
        return db.companyDao()
    }

    @Singleton
    @Provides
    fun provideCountryDao(db: ZenwelDb): CountryDao {
        return db.countryDao()
    }

    @Singleton
    @Provides
    fun provideCurrencyDao(db: ZenwelDb): CurrencyDao {
        return db.currencyDao()
    }

    @Singleton
    @Provides
    fun provideRoleDao(db: ZenwelDb): RoleDao {
        return db.roleDao()
    }

    @Singleton
    @Provides
    fun provideStateDao(db: ZenwelDb): StateDao {
        return db.stateDao()
    }

    @Singleton
    @Provides
    fun provideZoneDao(db: ZenwelDb): ZoneDao {
        return db.zoneDao()
    }

    @Singleton
    @Provides
    fun provideTaxDao(db: ZenwelDb): TaxDao {
        return db.taxDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(db: ZenwelDb): ProductDao {
        return db.productDao()
    }

    @Singleton
    @Provides
    fun provideCategoryDao(db: ZenwelDb): CategoryDao {
        return db.categoryDao()
    }

    @Singleton
    @Provides
    fun provideBrandDao(db: ZenwelDb): BrandDao {
        return db.brandDao()
    }

    @Singleton
    @Provides
    fun provideSupplierDao(db: ZenwelDb): SupplierDao {
        return db.supplierDao()
    }

    @Singleton
    @Provides
    fun provideStaffDao(db: ZenwelDb): StaffDao {
        return db.staffDao()
    }

    @Singleton
    @Provides
    fun provideCustomerDao(db: ZenwelDb): CustomerDao {
        return db.customerDao()
    }

    @Singleton
    @Provides
    fun provideServiceDao(db: ZenwelDb): ServiceDao {
        return db.serviceDao()
    }

    @Singleton
    @Provides
    fun provideClassDao(db: ZenwelDb): ClassDao {
        return db.classDao()
    }

    @Singleton
    @Provides
    fun provideCustomerBlockDao(db: ZenwelDb): CustomerBlockDao {
        return db.customerBlockDao()
    }

    @Singleton
    @Provides
    fun providePriceServiceDao(db: ZenwelDb): PriceServiceDao {
        return db.priceServiceDao()
    }

    @Singleton
    @Provides
    fun provideServiceGroupDao(db: ZenwelDb): ServiceGroupDao {
        return db.serviceGroupDao()
    }

    @Singleton
    @Provides
    fun provideServiceGroupObjectDao(db: ZenwelDb): ServiceGroupObjectDao {
        return db.serviceGroupObjectDao()
    }

    @Singleton
    @Provides
    fun provideServiceTreatmentTypeDao(db: ZenwelDb): ServiceTreatmentTypeDao {
        return db.serviceTreatmentTypeDao()
    }

    @Singleton
    @Provides
    fun provideCalendarDao(db: ZenwelDb): CalendarDao {
        return db.calendarDao()
    }

    @Singleton
    @Provides
    fun provideAppointmentDao(db: ZenwelDb): AppointmentDao {
        return db.appointmentDao()
    }

    @Singleton
    @Provides
    fun provideSalesDao(db: ZenwelDb): SalesDao {
        return db.salesDao()
    }

    @Singleton
    @Provides
    fun provideFacilityDao(db: ZenwelDb): FacilityDao {
        return db.facilityDao()
    }

    @Singleton
    @Provides
    fun provideSalesAppointmentDao(db: ZenwelDb): SalesAppointmentDao {
        return db.salesAppointmentDao()
    }

    @Singleton
    @Provides
    fun provideCalendarSetDao(db: ZenwelDb): CalendarSetDao {
        return db.calendarSetDao()
    }

    @Singleton
    @Provides
    fun provideSalesInvoiceDao(db: ZenwelDb): SalesInvoiceDao {
        return db.salesInvoiceDao()
    }

    @Singleton
    @Provides
    fun provideBookingSetDao(db: ZenwelDb): BookingSetDao {
        return db.bookingSetDao()
    }

    @Singleton
    @Provides
    fun provideVoucherDao(db: ZenwelDb): VoucherDao {
        return db.voucherDao()
    }

    @Singleton
    @Provides
    fun provideStaffNotifSetDao(db: ZenwelDb): StaffNotifSetDao {
        return db.staffNotifSetDao()
    }

    @Singleton
    @Provides
    fun provideCustomerNotifSetDao(db: ZenwelDb): CustomerNotifSetDao {
        return db.customerNotifSetDao()
    }

    @Singleton
    @Provides
    fun provideCancelReasonDao(db: ZenwelDb): CancelReasonDao {
        return db.cancelReasonDao()
    }

    @Singleton
    @Provides
    fun providePaymentTypeDao(db: ZenwelDb): PaymentTypeDao {
        return db.paymentTypeDao()
    }

    @Singleton
    @Provides
    fun provideDiscountTypeDao(db: ZenwelDb): DiscountTypeDao {
        return db.discountTypeDao()
    }

    @Singleton
    @Provides
    fun provideSalesSettingDao(db: ZenwelDb): SalesSettingDao {
        return db.salesSettingDao()
    }

    @Singleton
    @Provides
    fun provideDeviceDao(db: ZenwelDb): DeviceDao {
        return db.deviceDao()
    }

    @Singleton
    @Provides
    fun providePrinterDao(db: ZenwelDb): PrinterDao {
        return db.printerDao()
    }

    @Singleton
    @Provides
    fun provideOnlineInvoiceDao(db: ZenwelDb): OnlineInvoiceDao {
        return db.onlineInvoiceDao()
    }

    @Singleton
    @Provides
    fun provideMyAccountDao(db: ZenwelDb): MyAccountDao {
        return db.myAccountDao()
    }

    @Singleton
    @Provides
    fun provideCustomerAppointmentUpcomingDao(db: ZenwelDb): CustomerAppointmentUpcomingDao {
        return db.customerAppointmentUpcomingDao()
    }

    @Singleton
    @Provides
    fun provideDurationDao(db: ZenwelDb): DurationDao {
        return db.durationDao()
    }

    @Singleton
    @Provides
    fun provideSalesTransactionDao(db: ZenwelDb): SalesTransactionDao {
        return db.salesTransactionDao()
    }

    @Singleton
    @Provides
    fun provideServiceVariantDao(db: ZenwelDb): ServiceVariantDao {
        return db.serviceVariantDao()
    }

    @Singleton
    @Provides
    fun provideAppointmentVariantDao(db: ZenwelDb): AppointmentServiceDao {
        return db.appointmentServiceDao()
    }

    @Singleton
    @Provides
    fun providePermissionDao(db: ZenwelDb): PermissionDao {
        return db.permissionDao()
    }

    @Singleton
    @Provides
    fun provideAppointmentObjectDao(db: ZenwelDb): AppointmentObjectDao {
        return db.appointmentObjectDao()
    }

    @Singleton
    @Provides
    fun providePlanDao(db: ZenwelDb): PlanDao {
        return db.planDao()
    }

    @Singleton
    @Provides
    fun provideStoreInfoDao(db: ZenwelDb): StoreInfoDao {
        return db.storeInfoDao()
    }

    @Singleton
    @Provides
    fun provideResourcesPerLocationDao(db: ZenwelDb): ResourceLocationDao {
        return db.resourcesLocationDao()
    }

    @Singleton
    @Provides
    fun providePackageDao(db: ZenwelDb): PackageDao {
        return db.packageDao()
    }

    @Singleton
    @Provides
    fun providePackageDataServiceGroupDao(db: ZenwelDb): PackageDataServiceGroupDao {
        return db.packageDataServiceGroupDao()
    }

    @Singleton
    @Provides
    fun provideCheckoutDao(db: ZenwelDb): CheckoutDao {
        return db.checkoutDao()
    }

    @Singleton
    @Provides
    fun provideClassSessionCommissionDao(db: ZenwelDb): ClassSessionCommissionDao {
        return db.classSessionCommissionDao()
    }

    @Singleton
    @Provides
    fun provideClassPlanCommissionDao(db: ZenwelDb): ClassPlanCommissionDao {
        return db.classPlanCommissionDao()
    }

    @Singleton
    @Provides
    fun provideProductPriceCommissionDao(db: ZenwelDb): ProductPriceCommissionDao {
        return db.productPriceCommissionDao()
    }

    @Singleton
    @Provides
    fun provideServicePriceCommissionDao(db: ZenwelDb): ServicePriceCommissionDao {
        return db.servicePriceCommissionDao()
    }

    @Singleton
    @Provides
    fun provideVoucherCommissionDao(db: ZenwelDb): VoucherCommissionDao {
        return db.voucherCommissionDao()
    }

    @Singleton
    @Provides
    fun provideMasterStaffDao(db: ZenwelDb): MasterStaffDao {
        return db.masterStaffDao()
    }

    @Singleton
    @Provides
    fun provideMasterDiscountTypeDao(db: ZenwelDb): MasterDiscountTypeDao {
        return db.masterDiscountTypeDao()
    }

    @Singleton
    @Provides
    fun provideMasterLocationDao(db: ZenwelDb): MasterLocationDao {
        return db.masterLocationDao()
    }

    @Singleton
    @Provides
    fun provideMasterPaymentTypeDao(db: ZenwelDb): MasterPaymentTypeDao {
        return db.masterPaymentTypeDao()
    }

    @Singleton
    @Provides
    fun provideWorkingHourStaffDao(db: ZenwelDb): WorkingHourStaffDao {
        return db.workingHourStaffDao()
    }

    @Singleton
    @Provides
    fun provideMasterBrandDao(db: ZenwelDb): MasterBrandDao {
        return db.masterBrandDao()
    }

    @Singleton
    @Provides
    fun provideMasterProductDao(db: ZenwelDb): MasterProductDao {
        return db.masterProductDao()
    }

    @Singleton
    @Provides
    fun provideMasterPlanDao(db: ZenwelDb): MasterPlanDao {
        return db.masterPlanDao()
    }

    @Singleton
    @Provides
    fun provideMasterVoucherDao(db: ZenwelDb): MasterVoucherDao {
        return db.masterVoucherDao()
    }

    @Singleton
    @Provides
    fun providePaymentRoundingDao(db: ZenwelDb): PaymentRoundingDao {
        return db.paymentRoundingDao()
    }

    @Singleton
    @Provides
    fun provideMasterCategoryDao(db: ZenwelDb): MasterCategoryDao {
        return db.masterCategoryDao()
    }

    @Singleton
    @Provides
    fun provideSettingReceiptDao(db: ZenwelDb): SettingReceiptDao {
        return db.settingReceiptDao()
    }

    @Singleton
    @Provides
    fun provideInvRecSetFieldDao(db: ZenwelDb): InvRecSetFieldDao {
        return db.invRecSetFieldDao()
    }

    @Singleton
    @Provides
    fun provideSalesInvoiceOfflineDao(db: ZenwelDb): SalesInvoiceOfflineDao {
        return db.salesInvoiceOfflineDao()
    }

}