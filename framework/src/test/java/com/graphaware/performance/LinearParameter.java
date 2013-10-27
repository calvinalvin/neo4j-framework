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

package com.graphaware.performance;

import java.util.LinkedList;
import java.util.List;

/**
 * Linear {@link Parameter} generating an integer.
 */
public class LinearParameter extends NamedParameter<Integer> {

    private final List<Integer> values = new LinkedList<>();

    /**
     * Create a new parameter.
     *
     * @param name         param name.
     * @param min  minimum value of the parameter (inclusive).
     * @param max  maximum value of the parameter (inclusive).
     * @param step increment.
     */
    public LinearParameter(String name, int min, int max, int step) {
        super(name);

        for (int i = min; i <= max; i += step) {
            values.add(i);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> getValues() {
        return values;
    }
}