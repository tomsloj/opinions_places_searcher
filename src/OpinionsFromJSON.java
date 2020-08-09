import org.json.JSONArray;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;


public class OpinionsFromJSON
{
    public static void main(String[] args)
    {
        readFromJsonFile();
    }

    private static void readFromJsonFile()
    {
        try
        {
            String text = Files.readString(Paths.get("data.json"));

            JSONArray jsonArray = new JSONArray(text);

            // get opinions from JSON
            for( int i = 0;  i < jsonArray.length(); ++i )
            {
                JSONObject object = jsonArray.getJSONObject(i);
                String id = object.getString("id");
                String name = object.getString("name");
                String address = object.getString("address");
                double rating = object.getDouble("rating");

                DataBaseService.addPlace(id, name, address, rating);

                JSONArray reviews = object.getJSONArray("reviews");

                for ( int j = 0; j < reviews.length(); ++j )
                {
                    JSONObject opinion = reviews.getJSONObject(j);
                    String opinionText = opinion.getString("text");
                    double opinionRating = opinion.getDouble("rating");
                    DataBaseService.addOpinion(id, opinionText, opinionRating);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
