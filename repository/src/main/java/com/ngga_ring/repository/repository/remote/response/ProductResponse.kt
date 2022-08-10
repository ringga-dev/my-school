package com.ngga_ring.repository.repository.remote.response


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("current_page")
    var currentPage: Int? = null,
    @SerializedName("data")
    var `data`: List<Data>? = null,
    @SerializedName("first_page_url")
    var firstPageUrl: String? = null,
    @SerializedName("from")
    var from: Int? = null,
    @SerializedName("last_page")
    var lastPage: Int? = null,
    @SerializedName("last_page_url")
    var lastPageUrl: String? = null,
    @SerializedName("last_sync")
    var lastSync: String? = null,
    @SerializedName("next_page_url")
    var nextPageUrl: String? = null,
    @SerializedName("path")
    var path: String? = null,
    @SerializedName("per_page")
    var perPage: Int? = null,
    @SerializedName("prev_page_url")
    var prevPageUrl: Any? = null,
    @SerializedName("to")
    var to: Int? = null,
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("error")
    var error: String? = null,
) {
    data class Data(
        @SerializedName("active")
        var active: Boolean? = null,
        @SerializedName("addons")
        var addons: String? = null,
        @SerializedName("brand_id")
        var brandId: Any? = null,
        @SerializedName("buy_price")
        var buyPrice: String? = null,
        @SerializedName("currency_id")
        var currencyId: String? = null,
        @SerializedName("deleted")
        var deleted: Boolean? = null,
        @SerializedName("extra")
        var extra: String? = null,
        @SerializedName("has_addon")
        var hasAddon: Boolean? = null,
        @SerializedName("has_material")
        var hasMaterial: Int? = null,
        @SerializedName("has_variant")
        var hasVariant: Boolean? = null,
        @SerializedName("hold_qty")
        var holdQty: String? = null,
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("is_out_stock")
        var isOutStock: Int? = null,
        @SerializedName("is_popular")
        var isPopular: Int? = null,
        @SerializedName("low_stock_alert")
        var lowStockAlert: String? = null,
        @SerializedName("loyalty_points")
        var loyaltyPoints: String? = null,
        @SerializedName("market_price")
        var marketPrice: String? = null,
        @SerializedName("modified_sync_time")
        var modifiedSyncTime: String? = null,
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("non_taxable")
        var nonTaxable: Int? = null,
        @SerializedName("order_with_serial")
        var orderWithSerial: Int? = null,
        @SerializedName("photo_file")
        var photoFile: String? = null,
        @SerializedName("photo_url")
        var photoUrl: String? = null,
        @SerializedName("pos_hidden")
        var posHidden: Int? = null,
        @SerializedName("pos_sell_price_dynamic")
        var posSellPriceDynamic: Int? = null,
        @SerializedName("predefined_order_notes")
        var predefinedOrderNotes: Any? = null,
        @SerializedName("price_tiers")
        var priceTiers: String? = null,
        @SerializedName("product_group_id")
        var productGroupId: Int? = null,
        @SerializedName("product_group_name")
        var productGroupName: String? = null,
        @SerializedName("product_group_parent_id")
        var productGroupParentId: Any? = null,
        @SerializedName("published")
        var published: Int? = null,
        @SerializedName("sell_price")
        var sellPrice: String? = null,
        @SerializedName("sell_price_pos")
        var sellPricePos: String? = null,
        @SerializedName("serials")
        var serials: String? = null,
        @SerializedName("sku")
        var sku: String? = null,
        @SerializedName("status")
        var status: String? = null,
        @SerializedName("stock_qty")
        var stockQty: String? = null,
        @SerializedName("store_id")
        var storeId: Int? = null,
        @SerializedName("track_inventory")
        var trackInventory: Int? = null,
        @SerializedName("uom")
        var uom: String? = null,
        @SerializedName("variant_label")
        var variantLabel: String? = null,
        @SerializedName("variants")
        var variants: List<Variant>? = null,
        @SerializedName("weight")
        var weight: String? = null
    ) {
        data class Variant(
            @SerializedName("active")
            var active: Boolean? = null,
            @SerializedName("buy_price")
            var buyPrice: String? = null,
            @SerializedName("comission")
            var comission: String? = null,
            @SerializedName("currency_id")
            var currencyId: String? = null,
            @SerializedName("extra")
            var extra: String? = null,
            @SerializedName("hold_qty")
            var holdQty: String? = null,
            @SerializedName("id")
            var id: Int? = null,
            @SerializedName("is_out_stock")
            var isOutStock: Int? = null,
            @SerializedName("loyalty_points")
            var loyaltyPoints: String? = null,
            @SerializedName("market_price")
            var marketPrice: String? = null,
            @SerializedName("name")
            var name: String? = null,
            @SerializedName("photo_file")
            var photoFile: String? = null,
            @SerializedName("photo_url")
            var photoUrl: String? = null,
            @SerializedName("sell_price")
            var sellPrice: String? = null,
            @SerializedName("sell_price_pos")
            var sellPricePos: String? = null,
            @SerializedName("serials")
            var serials: String? = null,
            @SerializedName("sku")
            var sku: String? = null,
            @SerializedName("status")
            var status: String? = null,
            @SerializedName("stock_qty")
            var stockQty: String? = null,
            @SerializedName("store_id")
            var storeId: Int? = null,
            @SerializedName("view_order")
            var viewOrder: Int? = null,
            @SerializedName("vweight")
            var vweight: String? = null
        )
    }
}