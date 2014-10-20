package de.handler.mobile.android.shopprototype.database;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS
// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table ProductCategory.
 */
public class ProductCategory implements android.os.Parcelable {

    private Long id;
    private java.util.Date date;
    private long productId;
    private long categoryId;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient ProductCategoryDao myDao;

    private Product product;
    private Long product__resolvedKey;

    private Category category;
    private Long category__resolvedKey;


    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public ProductCategory() {
    }

    public ProductCategory(Long id) {
        this.id = id;
    }

    public ProductCategory(Long id, java.util.Date date, long productId, long categoryId) {
        this.id = id;
        this.date = date;
        this.productId = productId;
        this.categoryId = categoryId;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getProductCategoryDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    /** To-one relationship, resolved on first access. */
    public Product getProduct() {
        long __key = this.productId;
        if (product__resolvedKey == null || !product__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ProductDao targetDao = daoSession.getProductDao();
            Product productNew = targetDao.load(__key);
            synchronized (this) {
                product = productNew;
            	product__resolvedKey = __key;
            }
        }
        return product;
    }

    public void setProduct(Product product) {
        if (product == null) {
            throw new DaoException("To-one property 'productId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.product = product;
            productId = product.getId();
            product__resolvedKey = productId;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Category getCategory() {
        long __key = this.categoryId;
        if (category__resolvedKey == null || !category__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoryDao targetDao = daoSession.getCategoryDao();
            Category categoryNew = targetDao.load(__key);
            synchronized (this) {
                category = categoryNew;
            	category__resolvedKey = __key;
            }
        }
        return category;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new DaoException("To-one property 'categoryId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.category = category;
            categoryId = category.getId();
            category__resolvedKey = categoryId;
        }
    }

    /** Convenient call for . Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for . Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for . Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }


    // KEEP METHODS - put your custom methods here
    public ProductCategory(Parcel dest) {
        id = dest.readLong();
        date = new Date(dest.readLong());
        productId = dest.readLong();
        categoryId = dest.readLong();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeLong(date.getTime());
        dest.writeLong(productId);
        dest.writeLong(categoryId);
    }

    public static final Parcelable.Creator<ProductCategory> CREATOR
            = new Parcelable.Creator<ProductCategory>() {
        public ProductCategory createFromParcel(Parcel in) {
            return new ProductCategory(in);
        }

        public ProductCategory[] newArray(int size) {
            return new ProductCategory[size];
        }
    };
    // KEEP METHODS END

}
