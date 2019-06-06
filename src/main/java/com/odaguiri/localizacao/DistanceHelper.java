package com.odaguiri.localizacao;

/**
 * Coordenada número 1: -27.6019111(latitude), -48.5957299(longitude) Coordenada
 * número 2: -27.6066129(latitude), -48.5803426(longitude)
 * 
 * Simplificando a fórmula em um pseudo-código temos:
 * 
 * funcao haversine(latitude1, longitude1, latitude2, longitude2) { variavel
 * RAIO_TOTAL_DA_TERRA = 6371; // 6371KM variavel PI_EM_RADIANOS =
 * 0.017453292519943295; // (3,14 / 180)
 * 
 * variavel somatorioInterno = (0.5 - COSSENO((latitude2 - latitude1) *
 * PI_EM_RADIANOS)/2) + COSSENO(latitude1 * PI_EM_RADIANOS) * COSSENO(latitude2
 * * PI_EM_RADIANOS) ((1 - COSSENO(longitude2 - longitude1) * PI_EM_RADIANOS) /
 * 2);
 * 
 * retorna (RAIO_TOTAL_DA_TERRA * 2) *
 * ARCO_SENO(RAIZ_QUADRADA(somatorioInterno)); }
 *
 */
public class DistanceHelper {

	private static final int EARTH_RADIUS = 6371;
	private static final double PI_RADIUS = 0.017453292519943295;

	public static double distance(double startLat, double startLong, double endLat, double endLong) {

		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);

		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}

	public static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

	public static double haversine(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.pow(Math.sin(dLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return 6372.8 * c;
	}

	public static void haversine2() {
		// -27.6019111, -48.5957299, -27.6066129, -48.5803426
		final int R = 6371; // Radious of the earth
		Double lat1 = -27.6019111;
		Double lon1 = -48.5957299;
		Double lat2 = -27.6066129;
		Double lon2 = -48.5803426;
		Double latDistance = toRad(lat2 - lat1);
		Double lonDistance = toRad(lon2 - lon1);
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		Double distance = R * c;

		System.out.println("The distance between two lat and long is::" + distance);

	}

	private static Double toRad(Double value) {
		return value * Math.PI / 180;
	}

	public static void main(String[] args) {
//		variavel resultado = haversine(-27.6019111, -48.5957299, -27.6066129, -48.5803426);
//		O resultado deve ser: 1.603832548369759 KM
		double resultado = distance(-27.6019111, -48.5957299, -27.6066129, -48.5803426);
		System.out.println(resultado);
		resultado = haversine(-27.6019111, -48.5957299, -27.6066129, -48.5803426);
		System.out.println(resultado);
		haversine2();
	}
}
