/*
 * Copyright (c) 2013-2018 GraphAware
 *
 * This file is part of the GraphAware Framework.
 *
 * GraphAware Framework is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details. You should have received a copy of
 * the GNU General Public License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package com.graphaware.runtime.config;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.neo4j.kernel.impl.factory.OperationalMode;

import com.graphaware.common.policy.role.InstanceRole;
import com.graphaware.runtime.config.util.InstanceRoleUtils;
import com.graphaware.test.integration.EmbeddedDatabaseIntegrationTest;

/**
 * Test for @InstanceRoleUtils in single instance mode
 */
public class InstanceRoleUtilsSingleTest extends EmbeddedDatabaseIntegrationTest {

	private InstanceRoleUtils utils;
	
	@Before
	public void setUp() throws Exception{
		super.setUp();
		utils = new InstanceRoleUtils(getDatabase());
	}
	
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
	
	@Test
	public void testGetOperationalMode() {
		OperationalMode mode = utils.getOperationalMode();
		assertEquals(OperationalMode.single, mode);
	}

	@Test
	public void testGetInstaceRole() {
		InstanceRole role = utils.getInstanceRole();
		assertEquals(InstanceRole.SINGLE, role);
	}

	@Test
	public void testIsReadOnly() {
		assertFalse(utils.getInstanceRole().isReadOnly());
	}

}
