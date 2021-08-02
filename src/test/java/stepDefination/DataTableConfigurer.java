package stepDefination;

import java.util.Locale;
import java.util.Map;

import com.modals.Search;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;



@SuppressWarnings("deprecation")
public class DataTableConfigurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Search.class, new TableEntryTransformer<Search>() {
            @Override
            public Search transform(Map<String, String> entry) {
                return new Search(entry.get("keyword"), entry.get("location"), entry.get("radius"));
            }
        }));

     
    }

}