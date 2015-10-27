public class EnvironmentalFactors
{
		private int temperature;
		private int precipitation;
		private int humidity;
		private int sunshine;


		public EnvironmentalFactors(int temperature, int precipitation, int humidity, int sunshine)
		{
			this.temperature = temperature;
			this.precipitation = precipitation;
			this.humidity = humidity;
			this.sunshine = sunshine;
		}

		public int getTemperature() {return temperature;}
		public int getPrecipitation() {return precipitation;}
		public int getSunshine() {return sunshine;}
		public int getHumidity() {return humidity;}

}