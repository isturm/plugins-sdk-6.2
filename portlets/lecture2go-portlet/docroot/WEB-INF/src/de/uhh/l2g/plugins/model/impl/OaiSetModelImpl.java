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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import de.uhh.l2g.plugins.model.OaiSet;
import de.uhh.l2g.plugins.model.OaiSetModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the OaiSet service. Represents a row in the &quot;LG_OaiSet&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link de.uhh.l2g.plugins.model.OaiSetModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OaiSetImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see OaiSetImpl
 * @see de.uhh.l2g.plugins.model.OaiSet
 * @see de.uhh.l2g.plugins.model.OaiSetModel
 * @generated
 */
public class OaiSetModelImpl extends BaseModelImpl<OaiSet>
	implements OaiSetModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a oai set model instance should use the {@link de.uhh.l2g.plugins.model.OaiSet} interface instead.
	 */
	public static final String TABLE_NAME = "LG_OaiSet";
	public static final Object[][] TABLE_COLUMNS = {
			{ "oaiSetId", Types.BIGINT },
			{ "setSpec", Types.VARCHAR },
			{ "setName", Types.VARCHAR },
			{ "setDescription", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table LG_OaiSet (oaiSetId LONG not null primary key,setSpec VARCHAR(75) null,setName VARCHAR(75) null,setDescription VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table LG_OaiSet";
	public static final String ORDER_BY_JPQL = " ORDER BY oaiSet.oaiSetId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_OaiSet.oaiSetId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.OaiSet"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.OaiSet"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.OaiSet"));

	public OaiSetModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _oaiSetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOaiSetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _oaiSetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OaiSet.class;
	}

	@Override
	public String getModelClassName() {
		return OaiSet.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("oaiSetId", getOaiSetId());
		attributes.put("setSpec", getSetSpec());
		attributes.put("setName", getSetName());
		attributes.put("setDescription", getSetDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long oaiSetId = (Long)attributes.get("oaiSetId");

		if (oaiSetId != null) {
			setOaiSetId(oaiSetId);
		}

		String setSpec = (String)attributes.get("setSpec");

		if (setSpec != null) {
			setSetSpec(setSpec);
		}

		String setName = (String)attributes.get("setName");

		if (setName != null) {
			setSetName(setName);
		}

		String setDescription = (String)attributes.get("setDescription");

		if (setDescription != null) {
			setSetDescription(setDescription);
		}
	}

	@Override
	public long getOaiSetId() {
		return _oaiSetId;
	}

	@Override
	public void setOaiSetId(long oaiSetId) {
		_oaiSetId = oaiSetId;
	}

	@Override
	public String getSetSpec() {
		if (_setSpec == null) {
			return StringPool.BLANK;
		}
		else {
			return _setSpec;
		}
	}

	@Override
	public void setSetSpec(String setSpec) {
		_setSpec = setSpec;
	}

	@Override
	public String getSetName() {
		if (_setName == null) {
			return StringPool.BLANK;
		}
		else {
			return _setName;
		}
	}

	@Override
	public void setSetName(String setName) {
		_setName = setName;
	}

	@Override
	public String getSetDescription() {
		if (_setDescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _setDescription;
		}
	}

	@Override
	public void setSetDescription(String setDescription) {
		_setDescription = setDescription;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			OaiSet.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OaiSet toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OaiSet)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OaiSetImpl oaiSetImpl = new OaiSetImpl();

		oaiSetImpl.setOaiSetId(getOaiSetId());
		oaiSetImpl.setSetSpec(getSetSpec());
		oaiSetImpl.setSetName(getSetName());
		oaiSetImpl.setSetDescription(getSetDescription());

		oaiSetImpl.resetOriginalValues();

		return oaiSetImpl;
	}

	@Override
	public int compareTo(OaiSet oaiSet) {
		long primaryKey = oaiSet.getPrimaryKey();

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

		if (!(obj instanceof OaiSet)) {
			return false;
		}

		OaiSet oaiSet = (OaiSet)obj;

		long primaryKey = oaiSet.getPrimaryKey();

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
	}

	@Override
	public CacheModel<OaiSet> toCacheModel() {
		OaiSetCacheModel oaiSetCacheModel = new OaiSetCacheModel();

		oaiSetCacheModel.oaiSetId = getOaiSetId();

		oaiSetCacheModel.setSpec = getSetSpec();

		String setSpec = oaiSetCacheModel.setSpec;

		if ((setSpec != null) && (setSpec.length() == 0)) {
			oaiSetCacheModel.setSpec = null;
		}

		oaiSetCacheModel.setName = getSetName();

		String setName = oaiSetCacheModel.setName;

		if ((setName != null) && (setName.length() == 0)) {
			oaiSetCacheModel.setName = null;
		}

		oaiSetCacheModel.setDescription = getSetDescription();

		String setDescription = oaiSetCacheModel.setDescription;

		if ((setDescription != null) && (setDescription.length() == 0)) {
			oaiSetCacheModel.setDescription = null;
		}

		return oaiSetCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{oaiSetId=");
		sb.append(getOaiSetId());
		sb.append(", setSpec=");
		sb.append(getSetSpec());
		sb.append(", setName=");
		sb.append(getSetName());
		sb.append(", setDescription=");
		sb.append(getSetDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.OaiSet");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>oaiSetId</column-name><column-value><![CDATA[");
		sb.append(getOaiSetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setSpec</column-name><column-value><![CDATA[");
		sb.append(getSetSpec());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setName</column-name><column-value><![CDATA[");
		sb.append(getSetName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setDescription</column-name><column-value><![CDATA[");
		sb.append(getSetDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = OaiSet.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { OaiSet.class };
	private long _oaiSetId;
	private String _setSpec;
	private String _setName;
	private String _setDescription;
	private OaiSet _escapedModel;
}
