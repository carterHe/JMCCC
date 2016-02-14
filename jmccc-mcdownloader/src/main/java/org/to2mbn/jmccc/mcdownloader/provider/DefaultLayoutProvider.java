package org.to2mbn.jmccc.mcdownloader.provider;

import java.net.URI;
import java.net.URISyntaxException;
import org.to2mbn.jmccc.version.Asset;
import org.to2mbn.jmccc.version.Library;
import org.to2mbn.jmccc.version.Version;

abstract public class DefaultLayoutProvider extends URIDownloadProvider {

	@Override
	public URI getLibrary(Library library) {
		String baseurl = library.getCustomUrl();
		if (baseurl == null) {
			baseurl = getLibraryBaseURL();
		}
		String url = baseurl + library.getPath();
		if (library.getChecksums() != null) {
			url += ".pack.xz";
		}
		return toURI(url);
	}

	@Override
	public URI getGameJar(Version version) {
		return toURI(getVersionBaseURL() + version.getVersion() + "/" + version.getVersion() + ".jar");
	}

	@Override
	public URI getGameVersionJson(String version) {
		return toURI(getVersionBaseURL() + version + "/" + version + ".json");
	}

	@Override
	public URI getAssetIndex(Version version) {
		return toURI(getAssetIndexBaseURL() + version.getAssets() + ".json");
	}

	@Override
	public URI getVersionList() {
		return toURI(getVersionListURL());
	}

	@Override
	public URI getAsset(Asset asset) {
		return toURI(getAssetBaseURL() + asset.getPath());
	}

	private URI toURI(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new IllegalStateException("unable to convert " + uri + " to URI", e);
		}
	}

	abstract protected String getLibraryBaseURL();

	abstract protected String getVersionBaseURL();

	abstract protected String getAssetIndexBaseURL();

	abstract protected String getVersionListURL();

	abstract protected String getAssetBaseURL();

}