/*******************************************************************************
 * License
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Lecture2Go 
 * 
 * The Lecture2Go software is based on the liferay portal 6.2-ga6
 * <http://www.liferay.com> (Copyright notice see below)
 * Lecture2Go <http://lecture2go.uni-hamburg.de> is an open source
 * platform for media management and distribution. Our goal is to
 * support the free access to knowledge because this is a component
 * of each democratic society. The open source software is aimed at
 * academic institutions and has to strengthen the blended learning.
 * All Lecture2Go plugins are continuously being developed and improved.
 * For more details please visit <http://lecture2go-open-source.rrz.uni-hamburg.de>
 * Copyright (c) 2013 - present University of Hamburg / Computer and Data Center (RRZ)
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * The Liferay Plugins SDK:
 * 
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++ +++
 * 
 * Third Party Software
 * 
 * Lecture2Go uses third-party libraries which may be distributed under different licenses
 * to the above (but are compatible with the used GPL license). Informations about these
 * licenses and copyright informations are mostly detailed in the library source code or jars themselves.
 * You must agree to the terms of these licenses, in addition tothe above Lecture2Go source code license,
 * in order to use this software.
 ******************************************************************************/
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.model.Statistic;
import de.uhh.l2g.plugins.model.StatisticModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Statistic service. Represents a row in the &quot;LG_Statistic&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.StatisticModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StatisticImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see StatisticImpl
 * @see de.uhh.l2g.plugins.model.Statistic
 * @see de.uhh.l2g.plugins.model.StatisticModel
 * @generated
 */
public class StatisticModelImpl extends BaseModelImpl<Statistic>
	implements StatisticModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a statistic model instance should use the {@link de.uhh.l2g.plugins.model.Statistic} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Statistic";
	public static final Object[][] TABLE_COLUMNS = {
			{ "createDate", Types.TIMESTAMP },
			{ "publicVideos", Types.INTEGER },
			{ "privateVideos", Types.INTEGER },
			{ "autofillRow", Types.INTEGER },
			{ "statisticId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_Statistic (createDate DATE null,publicVideos INTEGER,privateVideos INTEGER,autofillRow INTEGER,statisticId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table LG_Statistic";
	public static final String ORDER_BY_JPQL = " ORDER BY statistic.statisticId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Statistic.statisticId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Statistic"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Statistic"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Statistic"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long STATISTICID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Statistic"));

	public StatisticModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _statisticId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStatisticId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _statisticId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Statistic.class;
	}

	@Override
	public String getModelClassName() {
		return Statistic.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("createDate", getCreateDate());
		attributes.put("publicVideos", getPublicVideos());
		attributes.put("privateVideos", getPrivateVideos());
		attributes.put("autofillRow", getAutofillRow());
		attributes.put("statisticId", getStatisticId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Integer publicVideos = (Integer)attributes.get("publicVideos");

		if (publicVideos != null) {
			setPublicVideos(publicVideos);
		}

		Integer privateVideos = (Integer)attributes.get("privateVideos");

		if (privateVideos != null) {
			setPrivateVideos(privateVideos);
		}

		Integer autofillRow = (Integer)attributes.get("autofillRow");

		if (autofillRow != null) {
			setAutofillRow(autofillRow);
		}

		Long statisticId = (Long)attributes.get("statisticId");

		if (statisticId != null) {
			setStatisticId(statisticId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask |= CREATEDATE_COLUMN_BITMASK;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@Override
	public int getPublicVideos() {
		return _publicVideos;
	}

	@Override
	public void setPublicVideos(int publicVideos) {
		_publicVideos = publicVideos;
	}

	@Override
	public int getPrivateVideos() {
		return _privateVideos;
	}

	@Override
	public void setPrivateVideos(int privateVideos) {
		_privateVideos = privateVideos;
	}

	@Override
	public int getAutofillRow() {
		return _autofillRow;
	}

	@Override
	public void setAutofillRow(int autofillRow) {
		_autofillRow = autofillRow;
	}

	@Override
	public long getStatisticId() {
		return _statisticId;
	}

	@Override
	public void setStatisticId(long statisticId) {
		_columnBitmask |= STATISTICID_COLUMN_BITMASK;

		if (!_setOriginalStatisticId) {
			_setOriginalStatisticId = true;

			_originalStatisticId = _statisticId;
		}

		_statisticId = statisticId;
	}

	public long getOriginalStatisticId() {
		return _originalStatisticId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Statistic.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Statistic toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Statistic)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StatisticImpl statisticImpl = new StatisticImpl();

		statisticImpl.setCreateDate(getCreateDate());
		statisticImpl.setPublicVideos(getPublicVideos());
		statisticImpl.setPrivateVideos(getPrivateVideos());
		statisticImpl.setAutofillRow(getAutofillRow());
		statisticImpl.setStatisticId(getStatisticId());
		statisticImpl.setGroupId(getGroupId());
		statisticImpl.setCompanyId(getCompanyId());
		statisticImpl.setUserId(getUserId());
		statisticImpl.setUserName(getUserName());
		statisticImpl.setModifiedDate(getModifiedDate());

		statisticImpl.resetOriginalValues();

		return statisticImpl;
	}

	@Override
	public int compareTo(Statistic statistic) {
		long primaryKey = statistic.getPrimaryKey();

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

		if (!(obj instanceof Statistic)) {
			return false;
		}

		Statistic statistic = (Statistic)obj;

		long primaryKey = statistic.getPrimaryKey();

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
		StatisticModelImpl statisticModelImpl = this;

		statisticModelImpl._originalCreateDate = statisticModelImpl._createDate;

		statisticModelImpl._originalStatisticId = statisticModelImpl._statisticId;

		statisticModelImpl._setOriginalStatisticId = false;

		statisticModelImpl._originalGroupId = statisticModelImpl._groupId;

		statisticModelImpl._setOriginalGroupId = false;

		statisticModelImpl._originalCompanyId = statisticModelImpl._companyId;

		statisticModelImpl._setOriginalCompanyId = false;

		statisticModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Statistic> toCacheModel() {
		StatisticCacheModel statisticCacheModel = new StatisticCacheModel();

		Date createDate = getCreateDate();

		if (createDate != null) {
			statisticCacheModel.createDate = createDate.getTime();
		}
		else {
			statisticCacheModel.createDate = Long.MIN_VALUE;
		}

		statisticCacheModel.publicVideos = getPublicVideos();

		statisticCacheModel.privateVideos = getPrivateVideos();

		statisticCacheModel.autofillRow = getAutofillRow();

		statisticCacheModel.statisticId = getStatisticId();

		statisticCacheModel.groupId = getGroupId();

		statisticCacheModel.companyId = getCompanyId();

		statisticCacheModel.userId = getUserId();

		statisticCacheModel.userName = getUserName();

		String userName = statisticCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			statisticCacheModel.userName = null;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			statisticCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			statisticCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return statisticCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{createDate=");
		sb.append(getCreateDate());
		sb.append(", publicVideos=");
		sb.append(getPublicVideos());
		sb.append(", privateVideos=");
		sb.append(getPrivateVideos());
		sb.append(", autofillRow=");
		sb.append(getAutofillRow());
		sb.append(", statisticId=");
		sb.append(getStatisticId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Statistic");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publicVideos</column-name><column-value><![CDATA[");
		sb.append(getPublicVideos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>privateVideos</column-name><column-value><![CDATA[");
		sb.append(getPrivateVideos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autofillRow</column-name><column-value><![CDATA[");
		sb.append(getAutofillRow());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statisticId</column-name><column-value><![CDATA[");
		sb.append(getStatisticId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Statistic.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Statistic.class
		};
	private Date _createDate;
	private Date _originalCreateDate;
	private int _publicVideos;
	private int _privateVideos;
	private int _autofillRow;
	private long _statisticId;
	private long _originalStatisticId;
	private boolean _setOriginalStatisticId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _modifiedDate;
	private long _columnBitmask;
	private Statistic _escapedModel;
}
