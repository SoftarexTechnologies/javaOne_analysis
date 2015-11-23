package models.responses;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QResponse is a Querydsl query type for Response
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QResponse extends EntityPathBase<Response> {

    private static final long serialVersionUID = -569156479L;

    public static final QResponse response = new QResponse("response");

    public final models.base.QBaseModel _super = new models.base.QBaseModel(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final SetPath<models.FieldResponse, models.QFieldResponse> fieldResponses = this.<models.FieldResponse, models.QFieldResponse>createSet("fieldResponses", models.FieldResponse.class, models.QFieldResponse.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QResponse(String variable) {
        super(Response.class, forVariable(variable));
    }

    public QResponse(Path<? extends Response> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResponse(PathMetadata<?> metadata) {
        super(Response.class, metadata);
    }

}

