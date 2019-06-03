package plan;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.Valid;

public class EventsConfiguration extends Configuration
{
    @NotEmpty
    private String dateFormat;

    public String getDateFormat()
    {
        return dateFormat;
    }

    @NotNull
    @Valid
    private final DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory(){
        return dataSourceFactory;
    }
}
