package com.landasource.wiidget.library.format;

import com.landasource.wiidget.Wiidget;
import com.landasource.wiidget.annotation.DefaultField;
import com.landasource.wiidget.engine.Position;
import com.landasource.wiidget.engine.ResourceLink;
import com.landasource.wiidget.validator.Required;

import com.landasource.wiidget.library.format.position.HtmlPositions;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public abstract class AbstractResourceLinkWiidget extends Wiidget implements ResourceLink {

	/**
	 * Position of resource.
	 */
	private Position position = HtmlPositions.HEAD_END.getPosition();

	/**
	 * 
	 */
	@Required
	@DefaultField
	private String url;

	@Override
	public Position getPosition() {
		return position;
	}

	@Override
	public void run() {
		super.run();

		getEngine().addResourceLink(this);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	/**
	 * @param positionName
	 */
	public void setPosition(final String positionName) {

		this.position = Enum.valueOf(HtmlPositions.class, positionName).getPosition();
	}

	@Override
	public String getSource() {
		return getUrl();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AbstractResourceLinkWiidget other = (AbstractResourceLinkWiidget) obj;
		if (position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!position.equals(other.position)) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}

}
