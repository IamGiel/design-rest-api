JwtInMemoryUserDetailsService

static {
inMemoryUserList.add(new JwtUserDetails(1L, "Gel",
"$2a$10\$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
}

# code hardcodes username and token

# jwt.io is a site to decode the token

# http://localhost:9191/authenticate provides the token with proper username and password.

# in application.properties check for jwt.signing.key.secret=mySecret

# mySecret is the signature at jwt.io
