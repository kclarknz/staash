package com.netflix.paas.dao;

/**
 * Unique identified for a DAO and it's entity.  The key makes it possible
 * to have the same entity class stored in different schemas
 * 
 * @author elandau
 *
 */
public class DaoKey<T> implements Comparable<DaoKey>{
    private final String schema;
    private final Class<T> type;
    
    public DaoKey(String schema, Class<T> type) {
        this.schema = schema;
        this.type   = type;
    }
    
    public String getSchema() {
        return schema;
    }
    public Class<T> getType() {
        return type;
    }

    @Override
    public int compareTo(DaoKey o) {
        int schemaCompare = schema.compareTo(o.schema);
        if (schemaCompare != 0)
            return schemaCompare;
        return this.type.getCanonicalName().compareTo(o.getType().getCanonicalName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((schema == null) ? 0 : schema.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        DaoKey other = (DaoKey) obj;
        if (!schema.equals(other.schema))
            return false;
        if (!type.equals(other.type))
            return false;
        return true;
    }


}
