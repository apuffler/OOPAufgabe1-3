
public class Environment{
    private float temperature;
    private float precipitation;
    private float humidity;
    private float sunshine;


    public Environment(float temperature, float precipitation, float humidity, float sunshine)
    {
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.sunshine = sunshine;
    }

    public float getTemperature() {return temperature;}
    public float getPrecipitation() {return precipitation;}
    public float getSunshine() {return sunshine;}
    public float getHumidity() {return humidity;}

}