
public class Environment{
    public  float temperature;
    public  float precipitation;
    public  float humidity;
    public  float sunshine;

 
    /**
	 * Environment represents environmental factors in a point in time. 
 	 * GOOD: Weak coupling
 	 * @param (temperature): float temperature must be >= 0
 	 * @param (precipitation):  float precipitation must be >= 0
 	 * @param (humidity):  float humidity must be >= 0
 	 * @param (sunshine):  float sunshine must be >= 0
 	 */
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