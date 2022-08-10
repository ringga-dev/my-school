package com.ngga_ring.repository.model.product

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Product(
    @PrimaryKey()
    @SerializedName("id") val id: Long = 0,
    @SerializedName("store_id") val storeId: Long = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("sku") val sku: String = "",
    @SerializedName("variant_label") val variantLabel: String = "",
    @SerializedName("product_group_id") val productGroupId: Long = 0,
    @SerializedName("currency_id") val currencyId: String = "",
    @SerializedName("market_price") val marketPrice: Double = 0.0,
    @SerializedName("sell_price") val sellPrice: Double = 0.0,
    @SerializedName("pos_sell_price_dynamic") val sellPriceDynamic: Int = 0,
    @SerializedName("loyalty_points") val loyaltyPoints: Double = 0.0,
    @SerializedName("track_inventory") val trackInventory: Int = 0,
    @SerializedName("stock_qty") val stockQty: Double = 0.0,
    @SerializedName("hold_qty") val holdQty: Double = 0.0,
    @SerializedName("low_stock_alert") val lowStockAlert: Double = 0.0,
    @SerializedName("is_popular") val isPopular: Int = 0,
    @SerializedName("has_variant") val hasVariant: Boolean = false,
    @SerializedName("has_addon") val hasAddOn: Boolean = false,
    @SerializedName("addons") val addOns: String = "",
    @SerializedName("serials") val serials: String = "",
    @SerializedName("price_tiers") val priceTiers: String = "",
    @SerializedName("predefined_order_notes") val orderNotes: String = "",
    @SerializedName("favorite") val favorite: Boolean = false,
    @SerializedName("order_with_serial") val withSerial: Int = 0,
    @SerializedName("weight") val weight: Double = 0.0,
    @SerializedName("photo_url") val photoUrl: String = "",
    @SerializedName("extra") val extra: String = "",
    @SerializedName("active") val active: Boolean = false,
    @SerializedName("deleted") val deleted: Boolean = false
) : Parcelable