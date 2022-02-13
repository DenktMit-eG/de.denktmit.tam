package de.denktmit.tam.webapp.springconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.*;
import java.net.URI;

@Configuration
@ConfigurationProperties(prefix = "de.denktmit.tam.web")
public class WebConfigurationProperties {

  @NotNull
  private HTTP_PROTOCOL protocol = HTTP_PROTOCOL.HTTP;

  @NotBlank
  @Pattern(regexp = "^[a-zA-Z]+$/")
  private String hostname = "localhost";

  @Min(1)
  @Max(65536)
  private int port = 8080;

  public URI getBaseUri() {
    String baseUri = (port == protocol.defaultPort)
      ? protocol.toLowercaseString() + "://" + hostname
      : protocol.toLowercaseString() + "://" + hostname + ":" + port;
    return URI.create(baseUri);
  }

  public HTTP_PROTOCOL getProtocol() {
    return protocol;
  }

  public void setProtocol(HTTP_PROTOCOL protocol) {
    this.protocol = protocol;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public enum HTTP_PROTOCOL {
    HTTP(80), HTTPS(443);

    public final int defaultPort;

    HTTP_PROTOCOL(int defaultPort) {
      this.defaultPort = defaultPort;
    }

    public String toLowercaseString() {
      return this.name().toLowerCase();
    }
  }
}
