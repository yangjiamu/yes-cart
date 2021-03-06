/*
 * Copyright 2009 Denys Pavlov, Igor Azarnyi
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.yes.cart.domain.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;


/**
 * Product.
 * <p/>
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:12:54
 */
public interface Product extends Auditable, Attributable, Seoable, Codable, Taggable {

    /**
     * When available on warehouse.
     */
    int AVAILABILITY_STANDARD = 1;
    /**
     * For preorder.
     */
    int AVAILABILITY_PREORDER = 2;
    /**
     * Available for backorder.
     */
    int AVAILABILITY_BACKORDER = 4;
    /**
     * Always available
     */
    int AVAILABILITY_ALWAYS = 8;
    /**
     * Only available as product information (cannot be purchased)
     */
    int AVAILABILITY_SHOWROOM = 16;

    /**
     * Get product pk.
     *
     * @return product pk.
     */
    long getProductId();

    /**
     * Set product pk.
     *
     * @param productId product pk.
     */
    void setProductId(long productId);

    /**
     * Get the unique product code.
     *
     * @return product code.
     */
    @Override
    String getCode();

    /**
     * Unique product code.
     * Limitation code must not contains underscore
     *
     * @param code unique code
     */
    @Override
    void setCode(String code);

    /**
     * Get the non unique product code.
     *
     * @return product code.
     */
    String getManufacturerCode();

    /**
     * Manufacturer non unique product code.
     * Limitation code must not contains underscore
     *
     * @param code manufacturer code
     */
    void setManufacturerCode(String code);

    /**
     * Get the non unique product code.
     *
     * @return product code.
     */
    String getManufacturerPartCode();

    /**
     * Manufacturer non unique product code.
     * Limitation code must not contains underscore
     *
     * @param code manufacturer code
     */
    void setManufacturerPartCode(String code);

    /**
     * Get the non unique product code.
     *
     * @return product code.
     */
    String getSupplierCode();

    /**
     * Supplier non unique product code.
     * Limitation code must not contains underscore
     *
     * @param code supplier code
     */
    void setSupplierCode(String code);

    /**
     * Get the non unique product catalog code.
     *
     * @return catalog code.
     */
    String getSupplierCatalogCode();

    /**
     * Supplier non unique catalog code.
     * Limitation code must not contains underscore
     *
     * @param code catalog code
     */
    void setSupplierCatalogCode(String code);

    /**
     * PIM external reference (e.g. IceCat, CNet etc)
     *
     * @return external reference
     */
    String getPimCode();

    /**
     * PIM external reference (e.g. IceCat, CNet etc)
     *
     * @param pimCode external reference
     */
    void setPimCode(String pimCode);


    /**
     * PIM updates are disabled for this product
     *
     * @return true means no PIM updates only manual
     */
    boolean getPimDisabled();

    /**
     * PIM updates are disabled for this product
     *
     * @param pimDisabled true means no PIM updates only manual
     */
    void setPimDisabled(boolean pimDisabled);


    /**
     * PIM updates are required, data is stale
     *
     * @return true means PIM data is old and needs update
     */
    boolean getPimOutdated();

    /**
     * PIM updates are required, data is stale
     *
     * @param pimOutdated true means PIM data is old and needs update
     */
    void setPimOutdated(boolean pimOutdated);


    /**
     * PIM last update timestamp
     *
     * @return last update timestamp
     */
    Instant getPimUpdated();

    /**
     * PIM last update timestamp
     *
     * @param pimUpdated last update timestamp
     */
    void setPimUpdated(Instant pimUpdated);



    /**
     * Get start of product availability.
     * Null - product has not start date, means no limitation.
     *
     * @return start of product availability.
     */
    LocalDateTime getAvailablefrom();

    /**
     * Set start of product availability.
     *
     * @param availablefrom start of product availability.
     */
    void setAvailablefrom(LocalDateTime availablefrom);

    /**
     * Get end of product availability.
     * Null - product has not end date, means no limitation.
     *
     * @return end of product availability.
     */
    LocalDateTime getAvailableto();

    /**
     * Set end of product availability.
     *
     * @param availableto end of product availability.
     */
    void setAvailableto(LocalDateTime availableto);

    /**
     * Get product availability
     *
     * @return  Availability
     */
    int getAvailability();

    /**
     * Set product availability
     *
     * @param availability product
     */
    void setAvailability(int availability);


    /**
     * Get the {@link Brand} of product.
     *
     * @return {@link Brand} of product.
     */
    Brand getBrand();

    /**
     * Set {@link Brand} of product.
     *
     * @param brand {@link Brand} of product.
     */
    void setBrand(Brand brand);

    /**
     * Get {@link ProductType}
     *
     * @return product type
     */
    ProductType getProducttype();

    /**
     * Set the {@link ProductType}
     *
     * @param producttype Get {@link ProductType}
     */
    void setProducttype(ProductType producttype);


    /**
     * Product's SKUs. SKU - Stock keeping unit or product variation. Each product has at least one sku.
     *
     * @return collection fo product skus.
     */
    Collection<ProductSku> getSku();

    /**
     * Set collection of skus.
     *
     * @param sku sku collection.
     */
    void setSku(Collection<ProductSku> sku);


    /**
     * Get all products attributes.
     *
     * @return collection of product attributes.
     */
    Set<AttrValueProduct> getAttributes();


    /**
     * Set collection of products attributes.
     *
     * @param attribute collection of products attributes
     */
    void setAttributes(Set<AttrValueProduct> attribute);

    /**
     * Get the assigned categories to product.
     *
     * @return assigned categories
     */
    Set<ProductCategory> getProductCategory();

    /**
     * Set assigned categories.
     *
     * @param productCategory assigned categories.
     */
    void setProductCategory(Set<ProductCategory> productCategory);

    /**
     * Get {@link ProductEnsembleOption} for product if it has ensemble flag
     *
     * @return Set of {@link ProductEnsembleOption} for product.
     */
    Set<ProductEnsembleOption> getEnsembleOption();

    /**
     * Set {@link ProductEnsembleOption} for product.
     *
     * @param ensembleOption {@link ProductEnsembleOption} for product
     */
    void setEnsembleOption(Set<ProductEnsembleOption> ensembleOption);

    /**
     * Set the product {@link ProductAssociation}, like up-sell, cross-sell, etc..
     *
     * @return product {@link ProductAssociation}.
     */
    Set<ProductAssociation> getProductAssociations();

    /**
     * Set product {@link ProductAssociation}.
     *
     * @param productAssociations product {@link ProductAssociation}.
     */
    void setProductAssociations(Set<ProductAssociation> productAssociations);



    /**
     * Get product name.
     *
     * @return product name.
     */
    @Override
    String getName();

    /**
     * Set product name.
     *
     * @param name product name.
     */
    @Override
    void setName(String name);

    /**
     * display name.
     *
     * @return display name.
     */
    String getDisplayName();

    /**
     * Get display name
     *
     * @param name display name
     */
    void setDisplayName(String name);

    /**
     * Get product description.
     *
     * @return product description.
     */
    @Override
    String getDescription();

    /**
     * Set product description.
     *
     * @param description product description.
     */
    @Override
    void setDescription(String description);

    /**
     * Get description for indexing
     *
     * @return as is description
     */
    String getDescriptionAsIs();

    /**
     * Get the default sku. For single sku product it will be only one sku.
     * In case of multi sku product default sku has the same sku code as product, otherwise
     * the first will be returned.,
     *
     * @return default sku or null if not found
     */
    ProductSku getDefaultSku();

    /**
     * Get the featured flag for product.
     *
     * @return set featured flag.
     */
    Boolean getFeatured();

    /**
     * Set product featured flag.
     *
     * @param featured featured flag.
     */
    void setFeatured(Boolean featured);


    /**
     * Get sku by given code.
     *
     * @param skuCode given sku code
     * @return product sku if found, otherwise null
     */
    ProductSku getSku(String skuCode);

    /**
     * Is product multisku .
     *
     * @return true if product multisku
     */
    boolean isMultiSkuProduct();


    /**
     * Get the space separated product tags. For example
     * sale specialoffer, newarrival etc.
     *
     * This tags should not be shown to customer, just for query navigation.
     *
     * @return space separated product tags
     */
    @Override
    String getTag();

    /**
     * Set space separated product tags.
     *
     * @param tag space separated product tags.
     */
    @Override
    void setTag(String tag);

    /**
     * Get minimal quantity for order. E.g. 5.0 means customer can only buy 5 or more.
     *
     * @return minimal order quantity
     */
    BigDecimal getMinOrderQuantity();

    /**
     * @param minOrderQuantity minimal quantity for order.
     */
    void setMinOrderQuantity(BigDecimal minOrderQuantity);

    /**
     * Get maximum quantity for order. E.g. 5.0 means customer can only buy up to 5
     *
     * @return maximum order quantity
     */
    BigDecimal getMaxOrderQuantity();

    /**
     * @param maxOrderQuantity maximum quantity for order.
     */
    void setMaxOrderQuantity(BigDecimal maxOrderQuantity);

    /**
     * Get step quantity for order. E.g. 5.0 means customer can only buy in batches of 5 - 5, 10, 15
     * but not say 11.
     *
     * @return step order quantity
     */
    BigDecimal getStepOrderQuantity();

    /**
     * @param stepOrderQuantity step quantity for order.
     */
    void setStepOrderQuantity(BigDecimal stepOrderQuantity);

}


