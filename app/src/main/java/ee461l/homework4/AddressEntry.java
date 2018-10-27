package ee461l.homework4;

public class AddressEntry {

    private String API_Key;

    private String streetAddress;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    private String url;
    private boolean acquired;

    private String jsonStr;
    private String formatted_address;
    private String place_id;
    private Double lat;
    private Double lng;

    AddressEntry(String apiKey){
        API_Key = apiKey;
        streetAddress = "";
        streetName = "";
        city = "";
        state = "";
        zipCode = "";
        country = "";
        url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        jsonStr = null;
        acquired = false;
        formatted_address = "";
        place_id = "";
        lat = 0.0;
        lng = 0.0;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void buildURL(){
        url = url.concat(streetAddress);
        url = url.concat(" ");
        url = url.concat(streetName);
        url = url.concat(", ");
        url = url.concat(city);
        url = url.concat(", ");
        url = url.concat(state);
        url = url.concat("&key=");
        url = url.concat(API_Key);
        url = url.replace(' ','+');
    }

    public String getURL(){
        return (url);
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public boolean isAcquired() {
        return (acquired);
    }

    public String getJsonStr() {
        return (acquired ? jsonStr : null);
    }

    private void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

//    public void parseResponse(String jsonStr) {
//        try {
//            Log.d("debug", jsonStr);
//            JSONArray raw = new JSONArray(jsonStr);
//            this.setRawResponse(raw.getJSONObject(0));
//
//            if(!raw.getJSONObject(1).getString("status").equals("OK")) {
//                acquired = false;
//                this.setRawResponse(null);
//                return;
//            }
//            formatted_address = rawResponse.getString("formatted_address");
//            place_id = rawResponse.getString("place_id");
//            lat = rawResponse.getJSONObject("geometry").getJSONObject("location").getDouble("lat");
//            lng = rawResponse.getJSONObject("geometry").getJSONObject("location").getDouble("lng");
//        } catch (final JSONException e) {
//            Log.e(TAG, "Json parsing error: " + e.getMessage());
//        }
//    }

    public void parseResponse(String jsonStr){
        if(jsonStr == null){
            return;
        }
        this.jsonStr = jsonStr;
        acquired = true;
        String[] tokens = jsonStr.split("[ ,\"\n\r\t:{}]+");
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("formatted_address")){
                formatted_address = tokens[++i];
            } else if (tokens[i].equals("location")){
                if(tokens[++i].equals("lat")) {
                    lat = Double.parseDouble(tokens[++i]);
                }
                if(tokens[++i].equals("lng")) {
                    lng = Double.parseDouble(tokens[++i]);
                }
            } else if (tokens[i].equals("place_id")){
                place_id = tokens[++i];
                break;
            }
        }
    }

    public String getFormatted_address() {
        return (acquired ? formatted_address : null);
    }

    private void setFormatted_address(String formatted_address){
        this.formatted_address = formatted_address;
    }

    public String getPlace_id() {
        return (acquired ? place_id : null);
    }

    private void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public Double getLat() {
        return (acquired ? lat : null);
    }

    private void setLat(Double lat){
        this.lat = lat;
    }

    public Double getLng() {
        return (acquired ? lng : null);
    }

    private void setLng(Double lng){
        this.lng = lng;
    }

}
