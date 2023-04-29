package com.restapi.restapi.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//Klass som hjälper oss att extrahera information från användaren och validera den
//Som tex, username, expire, rätt användare, generera token etc
@Service //auto format to bean
public class JwtService {

    //genererad från https://allkeysgenerator.com/. Kan hämta säkrare nycklar och sätta om denna
    //@Value("${key.location}")
    //private static String SECRET_KEY; // = "4528482B4D6251655468576D5A7134743777397A24432646294A404E63526655";
    private final static String SECRET_KEY = "4528482B4D6251655468576D5A7134743777397A24432646294A404E63526655";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Extrahera en claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims); //lista med alla claims som vi har från våran token
    }

    //generate token without additional claims
    public String generateToken(){ //UserDetails userDetails
        return generateToken(new HashMap<>()); //, userDetails
    }

    //generate token with additional claims
    public String generateToken(
            Map<String, Object> additionalClaims//,
            //UserDetails userDetails
    ){
        return Jwts
                .builder()
                .setClaims(additionalClaims)
                //.setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())) //Used to validate expire
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60)) //12 timmar + 1000 milis
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Validate token
    public boolean validToken(String token ){
        return !tokenExpired(token);
    }

    //returnerar sant eller falskt beroende på om token har utgått
    private boolean tokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    //få ut expired date
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /*
    Signing key
    secret som signar JWT
    Skapar sign delen
    Kollar om den signerade delen tillhör den som faktiskt frågar efter den
    person / client är den samma som personen som claimar token
    Du sätter nivån på hur säkert och hur stor tilliten är
     */
    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //decode key used to sign in
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
