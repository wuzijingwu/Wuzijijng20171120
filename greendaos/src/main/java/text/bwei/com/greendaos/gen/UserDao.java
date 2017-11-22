package text.bwei.com.greendaos.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import text.bwei.com.greendaos.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Thread_id = new Property(1, Integer.class, "thread_id", false, "THREAD_ID");
        public final static Property Start_pos = new Property(2, Integer.class, "start_pos", false, "START_POS");
        public final static Property End_pos = new Property(3, Integer.class, "end_pos", false, "END_POS");
        public final static Property Compelete_size = new Property(4, Integer.class, "compelete_size", false, "COMPELETE_SIZE");
        public final static Property Url = new Property(5, String.class, "url", false, "URL");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"THREAD_ID\" INTEGER," + // 1: thread_id
                "\"START_POS\" INTEGER," + // 2: start_pos
                "\"END_POS\" INTEGER," + // 3: end_pos
                "\"COMPELETE_SIZE\" INTEGER," + // 4: compelete_size
                "\"URL\" TEXT);"); // 5: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer thread_id = entity.getThread_id();
        if (thread_id != null) {
            stmt.bindLong(2, thread_id);
        }
 
        Integer start_pos = entity.getStart_pos();
        if (start_pos != null) {
            stmt.bindLong(3, start_pos);
        }
 
        Integer end_pos = entity.getEnd_pos();
        if (end_pos != null) {
            stmt.bindLong(4, end_pos);
        }
 
        Integer compelete_size = entity.getCompelete_size();
        if (compelete_size != null) {
            stmt.bindLong(5, compelete_size);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Integer thread_id = entity.getThread_id();
        if (thread_id != null) {
            stmt.bindLong(2, thread_id);
        }
 
        Integer start_pos = entity.getStart_pos();
        if (start_pos != null) {
            stmt.bindLong(3, start_pos);
        }
 
        Integer end_pos = entity.getEnd_pos();
        if (end_pos != null) {
            stmt.bindLong(4, end_pos);
        }
 
        Integer compelete_size = entity.getCompelete_size();
        if (compelete_size != null) {
            stmt.bindLong(5, compelete_size);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // thread_id
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // start_pos
            cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3), // end_pos
            cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // compelete_size
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setThread_id(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setStart_pos(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setEnd_pos(cursor.isNull(offset + 3) ? null : cursor.getInt(offset + 3));
        entity.setCompelete_size(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
