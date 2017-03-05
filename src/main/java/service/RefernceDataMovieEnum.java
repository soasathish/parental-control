package service;

import java.util.Arrays;

public enum RefernceDataMovieEnum {
	FINDING_DORY("0", "ACCESS_U"),
	STAR_WARS("1", "ACCESS_PG"), 
	VICEROY_HOUSE("2","ACCESS_12"),
	LOGAN("3","ACCESS_18"),
	FIRST_FIGHT("4","ACCESS_15")
	;
	String movie_id;
	String parentalControlLevel;

	public String getMovie_id() {
		return movie_id;
	}

	public String getParentalControlLevel() {
		return parentalControlLevel;
	}

	private RefernceDataMovieEnum(String movie_id, String parentalControlLevel) {
		this.movie_id = movie_id;
		this.parentalControlLevel = parentalControlLevel;
	}

	public static String getParentalLevels(String movieId) {

		String parentalControlLevelString = null;
		for (RefernceDataMovieEnum referencedataEnum : RefernceDataMovieEnum.values()) {
			if (movieId.equals(referencedataEnum.getMovie_id()))
				parentalControlLevelString = referencedataEnum.getParentalControlLevel();
			return parentalControlLevelString;

		}
		return parentalControlLevelString;

	}
}
