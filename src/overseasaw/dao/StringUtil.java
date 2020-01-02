package overseasaw.dao;

public class StringUtil 
{
	public static char Gender2Char(Gender g)
	{
		switch (g) {
		case MALE:
			return 'M';
		case FEMALE:
			return 'F';
		default:
			return 'U';
		}
	}
}
