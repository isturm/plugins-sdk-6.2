/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.LastvideolistModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Lastvideolist service. Represents a row in the &quot;LG_Lastvideolist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.LastvideolistModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LastvideolistImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistImpl
 * @see de.uhh.l2g.plugins.model.Lastvideolist
 * @see de.uhh.l2g.plugins.model.LastvideolistModel
 * @generated
 */
public class LastvideolistModelImpl extends BaseModelImpl<Lastvideolist>
	implements LastvideolistModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lastvideolist model instance should use the {@link de.uhh.l2g.plugins.model.Lastvideolist} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Lastvideolist";
	public static final Object[][] TABLE_COLUMNS = {
			{ "lastvideolistId", Types.BIGINT },
			{ "videoId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_Lastvideolist (lastvideolistId LONG not null primary key,videoId LONG)";
	public static final String TABLE_SQL_DROP = "drop table LG_Lastvideolist";
	public static final String ORDER_BY_JPQL = " ORDER BY lastvideolist.lastvideolistId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Lastvideolist.lastvideolistId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static long VIDEOID_COLUMN_BITMASK = 1L;
	public static long LASTVIDEOLISTID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Lastvideolist"));

	public LastvideolistModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _lastvideolistId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLastvideolistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lastvideolistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Lastvideolist.class;
	}

	@Override
	public String getModelClassName() {
		return Lastvideolist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lastvideolistId", getLastvideolistId());
		attributes.put("videoId", getVideoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lastvideolistId = (Long)attributes.get("lastvideolistId");

		if (lastvideolistId != null) {
			setLastvideolistId(lastvideolistId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}
	}

	@Override
	public long getLastvideolistId() {
		return _lastvideolistId;
	}

	@Override
	public void setLastvideolistId(long lastvideolistId) {
		_lastvideolistId = lastvideolistId;
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_columnBitmask |= VIDEOID_COLUMN_BITMASK;

		if (!_setOriginalVideoId) {
			_setOriginalVideoId = true;

			_originalVideoId = _videoId;
		}

		_videoId = videoId;
	}

	public long getOriginalVideoId() {
		return _originalVideoId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Lastvideolist.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Lastvideolist toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Lastvideolist)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LastvideolistImpl lastvideolistImpl = new LastvideolistImpl();

		lastvideolistImpl.setLastvideolistId(getLastvideolistId());
		lastvideolistImpl.setVideoId(getVideoId());

		lastvideolistImpl.resetOriginalValues();

		return lastvideolistImpl;
	}

	@Override
	public int compareTo(Lastvideolist lastvideolist) {
		long primaryKey = lastvideolist.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Lastvideolist)) {
			return false;
		}

		Lastvideolist lastvideolist = (Lastvideolist)obj;

		long primaryKey = lastvideolist.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		LastvideolistModelImpl lastvideolistModelImpl = this;

		lastvideolistModelImpl._originalVideoId = lastvideolistModelImpl._videoId;

		lastvideolistModelImpl._setOriginalVideoId = false;

		lastvideolistModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lastvideolist> toCacheModel() {
		LastvideolistCacheModel lastvideolistCacheModel = new LastvideolistCacheModel();

		lastvideolistCacheModel.lastvideolistId = getLastvideolistId();

		lastvideolistCacheModel.videoId = getVideoId();

		return lastvideolistCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{lastvideolistId=");
		sb.append(getLastvideolistId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lastvideolist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lastvideolistId</column-name><column-value><![CDATA[");
		sb.append(getLastvideolistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Lastvideolist.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Lastvideolist.class
		};
	private long _lastvideolistId;
	private long _videoId;
	private long _originalVideoId;
	private boolean _setOriginalVideoId;
	private long _columnBitmask;
	private Lastvideolist _escapedModel;
}