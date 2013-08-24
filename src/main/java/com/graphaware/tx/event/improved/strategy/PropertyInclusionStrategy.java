/*
 * Copyright (c) 2013 GraphAware
 *
 * This file is part of GraphAware.
 *
 * GraphAware is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 *  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.tx.event.improved.strategy;

import com.graphaware.framework.config.ConfigurationAsString;
import org.neo4j.graphdb.PropertyContainer;

/**
 * Strategy deciding which properties to include for the purposes of transaction data analysis.
 * <p/>
 * It is highly recommended to extend IncludeAllBusinessProperties from the GraphAware framework rather than implementing
 * this class directly, as it is important to ignore all GraphAware internal nodes for many applications.
 */
public interface PropertyInclusionStrategy<T extends PropertyContainer> extends ConfigurationAsString {

    /**
     * Should a property with the given key of the given property container be included for the purposes of transaction
     * data analysis.
     *
     * @param key               of the property.
     * @param propertyContainer containing the property.
     * @return true iff the property should be included.
     */
    boolean include(String key, T propertyContainer);
}
