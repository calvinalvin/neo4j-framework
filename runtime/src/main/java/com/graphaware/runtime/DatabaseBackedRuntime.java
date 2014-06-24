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

package com.graphaware.runtime;

import com.graphaware.runtime.config.DefaultRuntimeConfiguration;
import com.graphaware.runtime.config.RuntimeConfiguration;
import com.graphaware.runtime.manager.ProductionTransactionDrivenModuleManager;
import com.graphaware.runtime.manager.TimerDrivenModuleManager;
import com.graphaware.runtime.manager.TimerDrivenModuleManagerImpl;
import com.graphaware.runtime.manager.TransactionDrivenModuleManager;
import com.graphaware.runtime.metadata.ModuleMetadataRepository;
import com.graphaware.runtime.metadata.ProductionSingleNodeModuleMetadataRepository;
import com.graphaware.runtime.module.RuntimeModule;
import com.graphaware.runtime.module.TimerDrivenRuntimeModule;
import com.graphaware.runtime.module.TransactionDrivenRuntimeModule;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;


/**
 * {@link com.graphaware.runtime.GraphAwareRuntime} that operates on a real {@link org.neo4j.graphdb.GraphDatabaseService}.
 */
public class DatabaseBackedRuntime extends TransactionDrivenRuntime<TransactionDrivenRuntimeModule> {

    private final GraphDatabaseService database;

    protected DatabaseBackedRuntime(GraphDatabaseService database, TransactionDrivenModuleManager<TransactionDrivenRuntimeModule> transactionDrivenModuleManager) {
        super(transactionDrivenModuleManager);
        this.database = database;
        database.registerTransactionEventHandler(this);
        database.registerKernelEventHandler(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Class<TransactionDrivenRuntimeModule> supportedModule() {
        return TransactionDrivenRuntimeModule.class;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean databaseAvailable() {
        return database.isAvailable(0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Transaction startTransaction() {
        return database.beginTx();
    }
}
