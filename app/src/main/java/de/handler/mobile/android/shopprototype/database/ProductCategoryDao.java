package de.handler.mobile.android.shopprototype.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ProductCategory.
*/
public class ProductCategoryDao extends AbstractDao<ProductCategory, Long> {

    public static final String TABLENAME = "ProductCategory";

    /**
     * Properties of entity ProductCategory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Date = new Property(1, java.util.Date.class, "date", false, "DATE");
        public final static Property ProductId = new Property(2, long.class, "productId", false, "PRODUCT_ID");
        public final static Property CategoryId = new Property(3, long.class, "categoryId", false, "CATEGORY_ID");
    };

    private DaoSession daoSession;

    private Query<ProductCategory> product_ProductCategoriesQuery;
    private Query<ProductCategory> category_ProductCategoriesQuery;

    public ProductCategoryDao(DaoConfig config) {
        super(config);
    }
    
    public ProductCategoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ProductCategory' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'DATE' INTEGER," + // 1: date
                "'PRODUCT_ID' INTEGER NOT NULL ," + // 2: productId
                "'CATEGORY_ID' INTEGER NOT NULL );"); // 3: categoryId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ProductCategory'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ProductCategory entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(2, date.getTime());
        }
        stmt.bindLong(3, entity.getProductId());
        stmt.bindLong(4, entity.getCategoryId());
    }

    @Override
    protected void attachEntity(ProductCategory entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ProductCategory readEntity(Cursor cursor, int offset) {
        ProductCategory entity = new ProductCategory( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)), // date
            cursor.getLong(offset + 2), // productId
            cursor.getLong(offset + 3) // categoryId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ProductCategory entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDate(cursor.isNull(offset + 1) ? null : new java.util.Date(cursor.getLong(offset + 1)));
        entity.setProductId(cursor.getLong(offset + 2));
        entity.setCategoryId(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ProductCategory entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ProductCategory entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "productCategories" to-many relationship of Product. */
    public List<ProductCategory> _queryProduct_ProductCategories(long productId) {
        synchronized (this) {
            if (product_ProductCategoriesQuery == null) {
                QueryBuilder<ProductCategory> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ProductId.eq(null));
                queryBuilder.orderRaw("DATE ASC");
                product_ProductCategoriesQuery = queryBuilder.build();
            }
        }
        Query<ProductCategory> query = product_ProductCategoriesQuery.forCurrentThread();
        query.setParameter(0, productId);
        return query.list();
    }

    /** Internal query to resolve the "productCategories" to-many relationship of Category. */
    public List<ProductCategory> _queryCategory_ProductCategories(long categoryId) {
        synchronized (this) {
            if (category_ProductCategoriesQuery == null) {
                QueryBuilder<ProductCategory> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CategoryId.eq(null));
                queryBuilder.orderRaw("DATE ASC");
                category_ProductCategoriesQuery = queryBuilder.build();
            }
        }
        Query<ProductCategory> query = category_ProductCategoriesQuery.forCurrentThread();
        query.setParameter(0, categoryId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getProductDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getCategoryDao().getAllColumns());
            builder.append(" FROM ProductCategory T");
            builder.append(" LEFT JOIN PRODUCT T0 ON T.'PRODUCT_ID'=T0.'_id'");
            builder.append(" LEFT JOIN CATEGORY T1 ON T.'CATEGORY_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ProductCategory loadCurrentDeep(Cursor cursor, boolean lock) {
        ProductCategory entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Product product = loadCurrentOther(daoSession.getProductDao(), cursor, offset);
         if(product != null) {
            entity.setProduct(product);
        }
        offset += daoSession.getProductDao().getAllColumns().length;

        Category category = loadCurrentOther(daoSession.getCategoryDao(), cursor, offset);
         if(category != null) {
            entity.setCategory(category);
        }

        return entity;    
    }

    public ProductCategory loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<ProductCategory> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ProductCategory> list = new ArrayList<ProductCategory>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<ProductCategory> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ProductCategory> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
