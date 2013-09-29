package org.amolfasale.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.Mongo;

public class MongoUtil {

	private final static Logger logger = LoggerFactory
			.getLogger(MongoUtil.class);

	private static final int port = 27017;
	private static final String host = "localhost";
	private static Mongo mongo = null;

	public static Mongo getMongo() {
		if (mongo == null) {
			try {
					mongo = new Mongo(host, port);
				
				logger.debug("New Mongo created with [" + host + "] and ["
						+ port + "]");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return mongo;
	}
}
