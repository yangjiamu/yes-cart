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

package org.yes.cart.domain.dto.adapter.impl;

import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.ValueConverter;
import org.yes.cart.dao.GenericDAO;

/**
 * User: Igor Azarny iazarny@yahoo.com
 * Date: 09-May-2011
 * Time: 14:12:54
 */
public class GenericIdToEntityConverter<T> implements ValueConverter {

    private final GenericDAO<T, Long> genericDAO;

    public GenericIdToEntityConverter(final GenericDAO<T, Long> genericDAO) {
        this.genericDAO = genericDAO;
    }

    /** {@inheritDoc} */
    @Override
    public Object convertToDto(final Object object, final BeanFactory beanFactory) {
        throw new RuntimeException(this.getClass().getCanonicalName() + " not support conversion from id to entity " + object.getClass());
    }

    /** {@inheritDoc} */
    @Override
    public Object convertToEntity(final Object object, final Object oldEntity, final BeanFactory beanFactory) {
        if (object != null) {
            return genericDAO.findById((Long) object);
        }
        return null;
    }

}
