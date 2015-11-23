package models;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QOption is a Querydsl query type for Option
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QOption extends EntityPathBase<Option> {

    private static final long serialVersionUID = -1280047975L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOption option = new QOption("option");

    public final models.base.QBaseModel _super = new models.base.QBaseModel(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final models.fields.QField field;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath label = createString("label");

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QOption(String variable) {
        this(Option.class, forVariable(variable), INITS);
    }

    public QOption(Path<? extends Option> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOption(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QOption(PathMetadata<?> metadata, PathInits inits) {
        this(Option.class, metadata, inits);
    }

    public QOption(Class<? extends Option> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.field = inits.isInitialized("field") ? new models.fields.QField(forProperty("field")) : null;
    }

}

