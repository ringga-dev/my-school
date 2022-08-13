package com.zenwel.pos.di

import com.zenwel.pos.AppExecutors
import com.zenwel.pos.api.ApiService
import com.zenwel.pos.database.ZenwelDb
import com.zenwel.pos.database.dao.*
import com.zenwel.pos.models.PermissionDao
import com.zenwel.pos.repositories.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAnalyticsRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = AnalyticsRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideAppointmentRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            paymentTypeDao: PaymentTypeDao,
            appointmentObjectDao: AppointmentObjectDao,
            checkoutDao: CheckoutDao,
            staffDao: StaffDao,
            discountTypeDao: DiscountTypeDao,
            serviceVariantDao: ServiceVariantDao,
            appointmentDao: AppointmentDao,
            durationDao: DurationDao,
            masterStaffDao: MasterStaffDao,
            apiService: ApiService
    ) = AppointmentRepository(appExecutors, db, paymentTypeDao, appointmentObjectDao, checkoutDao, staffDao, discountTypeDao, serviceVariantDao, appointmentDao, durationDao, masterStaffDao, apiService)

    @Singleton
    @Provides
    fun provideBookingSetRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: BookingSetDao,
            apiService: ApiService
    ) = BookingSetRepository(appExecutors, apiService, db, dao)

    @Singleton
    @Provides
    fun provideBrandRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: BrandDao,
            brandDao: MasterBrandDao,
            apiService: ApiService
    ) = BrandRepository(appExecutors, db, dao, brandDao, apiService)

    @Singleton
    @Provides
    fun provideCalenderSetRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: CalendarSetDao,
            apiService: ApiService
    ) = CalenderSetRepository(appExecutors, apiService, db, dao)

    @Singleton
    @Provides
    fun provideCancelReasonRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: CancelReasonDao,
            apiService: ApiService
    ) = CancelReasonRepository(appExecutors, apiService, db, dao)

    @Singleton
    @Provides
    fun provideCategoryRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: CategoryDao,
            categoryDao: MasterCategoryDao,
            apiService: ApiService
    ) = CategoryRepository(appExecutors, db, dao, categoryDao, apiService)

    @Singleton
    @Provides
    fun provideClassRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            planDao: PlanDao,
            classDao: ClassDao,
            apiService: ApiService
    ) = ClassRepository(appExecutors, db, classDao, planDao, apiService)

    @Singleton
    @Provides
    fun provideClosedDateRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: ClosedDateDao,
            apiService: ApiService
    ) = ClosedDateRepository(appExecutors, db, dao, apiService)

    @Singleton
    @Provides
    fun provideCompanyRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            dao: CompanyDao,
            apiService: ApiService
    ) = CompanyRepository(appExecutors, db, dao, apiService)

    @Singleton
    @Provides
    fun provideCustomerNotifSetRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = CustomerNotifSetRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideCustomerRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            customerDao: CustomerDao,
            customerBlockDao: CustomerBlockDao,
            apiService: ApiService
    ) = CustomerRepository(appExecutors, apiService, db, customerDao, customerBlockDao)

    @Singleton
    @Provides
    fun provideDashboardRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = DashboardRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideDeviceRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = DeviceRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideDiscountTypeRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            discountTypeDao: DiscountTypeDao,
            masterDiscountTypeDao: MasterDiscountTypeDao,
    ) = DiscountTypeRepository(appExecutors, apiService, db, discountTypeDao, masterDiscountTypeDao)

    @Singleton
    @Provides
    fun provideFacilityRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            facilityDao: FacilityDao
    ) = FacilityRepository(appExecutors, apiService, db, facilityDao)

    @Singleton
    @Provides
    fun provideGlobalRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            businessTypeDao: BusinessTypeDao,
            currencyDao: CurrencyDao,
            countryDao: CountryDao,
            stateDao: StateDao,
            cityDao: CityDao,
            roleDao: RoleDao,
            zoneDao: ZoneDao,
            durationDao: DurationDao,
            companyDao: CompanyDao,
            masterStaffDao: MasterStaffDao,
            masterDiscountTypeDao: MasterDiscountTypeDao
    ) = GlobalRepository(appExecutors, db, businessTypeDao, currencyDao, countryDao, stateDao, cityDao, roleDao, zoneDao, durationDao, companyDao, masterStaffDao, masterDiscountTypeDao, apiService)

    @Singleton
    @Provides
    fun provideInvoiceReceiptSetRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            settingReceiptDao: SettingReceiptDao,
            invRecSetFieldDao: InvRecSetFieldDao
    ) = InvoiceReceiptSetRepository(appExecutors, apiService, db, settingReceiptDao, invRecSetFieldDao)

    @Singleton
    @Provides
    fun provideLocationsRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            locationDao: LocationDao,
            masterLocationDao: MasterLocationDao
    ) = LocationsRepository(appExecutors, db, locationDao, masterLocationDao, apiService)

    @Singleton
    @Provides
    fun provideMessageRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = MessageRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideMyAccountRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            myAccountDao: MyAccountDao
    ) = MyAccountRepository(appExecutors, db, myAccountDao, apiService)

    @Singleton
    @Provides
    fun provideNotificationRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = NotificationRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideOrderRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = OrderRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun providePaymentTypeRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            paymentTypeDao: PaymentTypeDao,
            masterPaymentTypeDao: MasterPaymentTypeDao
    ) = PaymentTypeRepository(appExecutors, apiService, db, paymentTypeDao, masterPaymentTypeDao)

    @Singleton
    @Provides
    fun providePrinterRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            printerDao: PrinterDao
    ) = PrinterRepository(appExecutors, db, printerDao)

    @Singleton
    @Provides
    fun provideProductRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            productDao: ProductDao,
            masterProductDao: MasterProductDao
    ) = ProductRepository(appExecutors, db, productDao, masterProductDao, apiService)

    @Singleton
    @Provides
    fun provideResourceRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            resourceLocationDao: ResourceLocationDao
    ) = ResourceRepository(appExecutors, db, resourceLocationDao, apiService)

    @Singleton
    @Provides
    fun provideSalesRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            salesInvoiceDao: SalesInvoiceDao,
            salesInvoiceOfflineDao: SalesInvoiceOfflineDao
    ) = SalesRepository(appExecutors, apiService, db, salesInvoiceDao, salesInvoiceOfflineDao)

    @Singleton
    @Provides
    fun provideSalesSettingRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            salesSettingDao: SalesSettingDao,
            paymentRoundingDao: PaymentRoundingDao
    ) = SalesSettingRepository(appExecutors, apiService, db, salesSettingDao, paymentRoundingDao)

    @Singleton
    @Provides
    fun provideSalesTransactionRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            salesTransactionDao: SalesTransactionDao,
            salesInvoiceOfflineDao: SalesInvoiceOfflineDao
    ) = SalesTransactionRepository(appExecutors, db, salesTransactionDao, salesInvoiceOfflineDao)

    @Singleton
    @Provides
    fun provideServiceGroupRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            serviceGroupDao: ServiceGroupDao
    ) = ServiceGroupRepository(appExecutors, db, serviceGroupDao, apiService)

    @Singleton
    @Provides
    fun provideServiceRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            serviceDao: ServiceDao,
            serviceVariantDao: ServiceVariantDao,
            serviceTreatmentTypeDao: ServiceTreatmentTypeDao,
            packageDao: PackageDao
    ) = ServiceRepository(appExecutors, db, serviceDao, serviceVariantDao, serviceTreatmentTypeDao, packageDao, apiService)

    @Singleton
    @Provides
    fun provideStaffNotifSetRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            staffNotifSetDao: StaffNotifSetDao
    ) = StaffNotifSetRepository(appExecutors, apiService, db, staffNotifSetDao)

    @Singleton
    @Provides
    fun provideStaffRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            staffDao: StaffDao,
            permissionDao: PermissionDao,
            servicePriceCommissionDao: ServicePriceCommissionDao,
            productPriceCommissionDao: ProductPriceCommissionDao,
            classSessionCommissionDao: ClassSessionCommissionDao,
            classPlanCommissionDao: ClassPlanCommissionDao,
            voucherCommissionDao: VoucherCommissionDao,
            workingHourStaffDao: WorkingHourStaffDao
    ) = StaffRepository(appExecutors, db, staffDao, permissionDao, servicePriceCommissionDao, productPriceCommissionDao, classSessionCommissionDao, classPlanCommissionDao, voucherCommissionDao, workingHourStaffDao, apiService)

    @Singleton
    @Provides
    fun provideSubscriptionRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            locationDao: LocationDao
    ) = SubscriptionRepository(appExecutors, apiService, db, locationDao)

    @Singleton
    @Provides
    fun provideSupplierRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            supplierDao: SupplierDao,
            companyDao: CompanyDao
    ) = SupplierRepository(appExecutors, db, supplierDao, companyDao, apiService)

    @Singleton
    @Provides
    fun provideTaxRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            taxDao: TaxDao
    ) = TaxRepository(appExecutors, db, taxDao, apiService)

    @Singleton
    @Provides
    fun provideUserRepository(
            appExecutors: AppExecutors,
            apiService: ApiService
    ) = UserRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideVoucherRepository(
            appExecutors: AppExecutors,
            apiService: ApiService,
            db: ZenwelDb,
            voucherDao: VoucherDao
    ) = VoucherRepository(appExecutors, apiService, db, voucherDao)

    @Singleton
    @Provides
    fun provideLoyaltyPointRepository(
        appExecutors: AppExecutors,
        apiService: ApiService
    ) = LoyaltyPointRepository(appExecutors, apiService)

    @Singleton
    @Provides
    fun provideGeneralRepository(
            appExecutors: AppExecutors,
            db: ZenwelDb,
            apiService: ApiService
    ) = GeneralRepository(appExecutors, db, apiService)

}