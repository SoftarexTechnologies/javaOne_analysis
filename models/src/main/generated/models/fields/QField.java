package models.fields;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QField is a Querydsl query type for Field
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QField extends EntityPathBase<Field> {

    private static final long serialVersionUID = 1120660073L;

    public static final QField field = new QField("field");

    public final models.base.QBaseModel _super = new models.base.QBaseModel(this);

    public final BooleanPath active = createBoolean("active");

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath label = createString("label");

    public final SetPath<models.Option, models.QOption> options = this.<models.Option, models.QOption>createSet("options", models.Option.class, models.QOption.class, PathInits.DIRECT2);

    public final BooleanPath required = createBoolean("required");

    public final SetPath<models.FieldResponse, models.QFieldResponse> responses = this.<models.FieldResponse, models.QFieldResponse>createSet("responses", models.FieldResponse.class, models.QFieldResponse.class, PathInits.DIRECT2);

    public final EnumPath<models.enums.FieldType> type = createEnum("type", models.enums.FieldType.class);

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QField(String variable) {
        super(Field.class, forVariable(variable));
    }

    public QField(Path<? extends Field> path) {
        super(path.getType(), path.getMetadata());
    }

    public QField(PathMetadata<?> metadata) {
        super(Field.class, metadata);
    }

}

