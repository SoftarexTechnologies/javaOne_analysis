package models;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QFieldResponse is a Querydsl query type for FieldResponse
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFieldResponse extends EntityPathBase<FieldResponse> {

    private static final long serialVersionUID = -1930308937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFieldResponse fieldResponse = new QFieldResponse("fieldResponse");

    public final models.base.QBaseModel _super = new models.base.QBaseModel(this);

    public final StringPath answer = createString("answer");

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final models.fields.QField field;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final models.responses.QResponse response;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QFieldResponse(String variable) {
        this(FieldResponse.class, forVariable(variable), INITS);
    }

    public QFieldResponse(Path<? extends FieldResponse> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFieldResponse(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFieldResponse(PathMetadata<?> metadata, PathInits inits) {
        this(FieldResponse.class, metadata, inits);
    }

    public QFieldResponse(Class<? extends FieldResponse> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.field = inits.isInitialized("field") ? new models.fields.QField(forProperty("field")) : null;
        this.response = inits.isInitialized("response") ? new models.responses.QResponse(forProperty("response")) : null;
    }

}

