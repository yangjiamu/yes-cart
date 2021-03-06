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

package org.yes.cart.domain.misc.navigation.range.impl;

import org.yes.cart.domain.misc.navigation.range.DisplayValue;
import org.yes.cart.domain.misc.navigation.range.RangeNode;

import java.util.List;

/**
 * Value range implementation.
 * <p/>
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 07-May-2011
 * Time: 11:12:54
 */
public class RangeNodeImpl implements RangeNode {

    private String from;
    private String to;
    private List<DisplayValue> i18n;

    /** {@inheritDoc} */
    @Override
    public String getFrom() {
        return from;
    }

    /** {@inheritDoc} */
    @Override
    public void setFrom(final String from) {
        this.from = from;
    }

    /** {@inheritDoc} */
    @Override
    public String getTo() {
        return to;
    }

    /** {@inheritDoc} */
    @Override
    public void setTo(final String to) {
        this.to = to;
    }

    /** {@inheritDoc} */
    @Override
    public List<DisplayValue> getI18n() {
        return i18n;
    }

    /** {@inheritDoc} */
    @Override
    public void setI18n(final List<DisplayValue> fromDisplay) {
        this.i18n = fromDisplay;
    }

    /**
     * Construct value range. Default constructor
     */
    public RangeNodeImpl() {
	    super();
    }

    /**
     * Construct value range.
     *
     * @param loValue lo value of range
     * @param hiValue hi value of range
     */
    public RangeNodeImpl(final String loValue, final String hiValue) {
        from = loValue;
        to = hiValue;
    }
}
