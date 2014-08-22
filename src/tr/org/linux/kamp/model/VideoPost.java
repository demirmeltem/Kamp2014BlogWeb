package tr.org.linux.kamp.model;

public class VideoPost extends Post {

	private String videoUrl;

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public VideoPost(String title, String content, String videoUrl) {
		super(title, content);
		this.videoUrl = videoUrl;
	}

}
