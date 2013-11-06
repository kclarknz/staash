package com.netflix.paas.resources;

import java.util.List;

import javax.ws.rs.Path;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netflix.paas.SchemaNames;
import com.netflix.paas.dao.Dao;
import com.netflix.paas.dao.DaoSchema;
import com.netflix.paas.dao.DaoSchemaProvider;
import com.netflix.paas.dao.DaoProvider;
import com.netflix.paas.dao.DaoStatus;
import com.netflix.paas.exceptions.NotFoundException;

@Path("/1/setup")
@Singleton
/**
 * API to set up storage for the PAAS application
 * 
 * @author elandau
 */
public class BootstrapResource {
    private DaoProvider daoProvider;
    
    @Inject
    public BootstrapResource(DaoProvider daoProvider) {
        this.daoProvider = daoProvider;
    }
    
    @Path("storage/create")
    public void createStorage() throws NotFoundException {
        DaoSchema schema = daoProvider.getSchema(SchemaNames.CONFIGURATION.name());
        if (!schema.isExists()) {
            schema.createSchema();
        }
        
        for (Dao<?> dao : schema.listDaos()) {
            dao.createTable();
        }
    }
    
    @Path("storage/status")
    public List<DaoStatus> getStorageStatus() throws NotFoundException {
        return Lists.newArrayList(Collections2.transform(
            daoProvider.getSchema(SchemaNames.CONFIGURATION.name()).listDaos(),
            new Function<Dao<?>, DaoStatus>() {
                @Override
                public DaoStatus apply(Dao<?> dao) {
                    return dao;
                }
        }));
    }
}
