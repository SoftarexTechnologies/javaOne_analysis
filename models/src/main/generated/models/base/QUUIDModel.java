package models.base;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUUIDModel is a Querydsl query type for UUIDModel
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QUUIDModel extends EntityPathBase<UUIDModel> {

    private static final long serialVersionUID = 1735086421L;

    public static final QUUIDModel uUIDModel = new QUUIDModel("uUIDModel");

    public final QBaseModel _super = new QBaseModel(this);

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final StringPath uuid = createString("uuid");

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QUUIDModel(String variable) {
        super(UUIDModel.class, forVariable(variable));
    }

    public QUUIDModel(Path<? extends UUIDModel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUUIDModel(PathMetadata<?> metadata) {
        super(UUIDModel.class, metadata);
    }

}

