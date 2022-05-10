import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Nasa {
    private String copyright;
    private Date date;
    private String explanation;
    private String hdurl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public Nasa(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public void setMediaType(String media_type) {
        this.mediaType = media_type;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Nasa { \n  copyright = '").append(copyright)
                .append("',\n  date = ").append(date)
                .append("',\n  explanation = '").append(explanation)
                .append("',\n  mediaType = '").append(mediaType)
                .append("',\n  hdurl = '").append(hdurl)
                .append("',\n  serviceVersion = '").append(serviceVersion)
                .append("',\n  title = '").append(title)
                .append("',\n  url = '").append(url).append("'\n}");
        return  String.valueOf(result);
    }
}
