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

package de.uhh.l2g.plugins.migration.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import de.uhh.l2g.plugins.migration.model.LegacyMetadata;
import de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalService;
import de.uhh.l2g.plugins.migration.service.persistence.LegacyContactPersistence;
import de.uhh.l2g.plugins.migration.service.persistence.LegacyLectureSeriesFacilityPersistence;
import de.uhh.l2g.plugins.migration.service.persistence.LegacyMetadataPersistence;
import de.uhh.l2g.plugins.migration.service.persistence.LegacyOfficePersistence;
import de.uhh.l2g.plugins.migration.service.persistence.LegacySegmentPersistence;
import de.uhh.l2g.plugins.migration.service.persistence.LegacyUserPersistence;
import de.uhh.l2g.plugins.migration.service.persistence.TestEntityTwoPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the legacy metadata local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.uhh.l2g.plugins.migration.service.impl.LegacyMetadataLocalServiceImpl}.
 * </p>
 *
 * @author unihh
 * @see de.uhh.l2g.plugins.migration.service.impl.LegacyMetadataLocalServiceImpl
 * @see de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil
 * @generated
 */
public abstract class LegacyMetadataLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements LegacyMetadataLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalServiceUtil} to access the legacy metadata local service.
	 */

	/**
	 * Adds the legacy metadata to the database. Also notifies the appropriate model listeners.
	 *
	 * @param legacyMetadata the legacy metadata
	 * @return the legacy metadata that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LegacyMetadata addLegacyMetadata(LegacyMetadata legacyMetadata)
		throws SystemException {
		legacyMetadata.setNew(true);

		return legacyMetadataPersistence.update(legacyMetadata);
	}

	/**
	 * Creates a new legacy metadata with the primary key. Does not add the legacy metadata to the database.
	 *
	 * @param id the primary key for the new legacy metadata
	 * @return the new legacy metadata
	 */
	@Override
	public LegacyMetadata createLegacyMetadata(long id) {
		return legacyMetadataPersistence.create(id);
	}

	/**
	 * Deletes the legacy metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the legacy metadata
	 * @return the legacy metadata that was removed
	 * @throws PortalException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LegacyMetadata deleteLegacyMetadata(long id)
		throws PortalException, SystemException {
		return legacyMetadataPersistence.remove(id);
	}

	/**
	 * Deletes the legacy metadata from the database. Also notifies the appropriate model listeners.
	 *
	 * @param legacyMetadata the legacy metadata
	 * @return the legacy metadata that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public LegacyMetadata deleteLegacyMetadata(LegacyMetadata legacyMetadata)
		throws SystemException {
		return legacyMetadataPersistence.remove(legacyMetadata);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(LegacyMetadata.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return legacyMetadataPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return legacyMetadataPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return legacyMetadataPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return legacyMetadataPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return legacyMetadataPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public LegacyMetadata fetchLegacyMetadata(long id)
		throws SystemException {
		return legacyMetadataPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the legacy metadata with the primary key.
	 *
	 * @param id the primary key of the legacy metadata
	 * @return the legacy metadata
	 * @throws PortalException if a legacy metadata with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LegacyMetadata getLegacyMetadata(long id)
		throws PortalException, SystemException {
		return legacyMetadataPersistence.findByPrimaryKey(id);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return legacyMetadataPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the legacy metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.migration.model.impl.LegacyMetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of legacy metadatas
	 * @param end the upper bound of the range of legacy metadatas (not inclusive)
	 * @return the range of legacy metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<LegacyMetadata> getLegacyMetadatas(int start, int end)
		throws SystemException {
		return legacyMetadataPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of legacy metadatas.
	 *
	 * @return the number of legacy metadatas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getLegacyMetadatasCount() throws SystemException {
		return legacyMetadataPersistence.countAll();
	}

	/**
	 * Updates the legacy metadata in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param legacyMetadata the legacy metadata
	 * @return the legacy metadata that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public LegacyMetadata updateLegacyMetadata(LegacyMetadata legacyMetadata)
		throws SystemException {
		return legacyMetadataPersistence.update(legacyMetadata);
	}

	/**
	 * Returns the legacy contact local service.
	 *
	 * @return the legacy contact local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacyContactLocalService getLegacyContactLocalService() {
		return legacyContactLocalService;
	}

	/**
	 * Sets the legacy contact local service.
	 *
	 * @param legacyContactLocalService the legacy contact local service
	 */
	public void setLegacyContactLocalService(
		de.uhh.l2g.plugins.migration.service.LegacyContactLocalService legacyContactLocalService) {
		this.legacyContactLocalService = legacyContactLocalService;
	}

	/**
	 * Returns the legacy contact persistence.
	 *
	 * @return the legacy contact persistence
	 */
	public LegacyContactPersistence getLegacyContactPersistence() {
		return legacyContactPersistence;
	}

	/**
	 * Sets the legacy contact persistence.
	 *
	 * @param legacyContactPersistence the legacy contact persistence
	 */
	public void setLegacyContactPersistence(
		LegacyContactPersistence legacyContactPersistence) {
		this.legacyContactPersistence = legacyContactPersistence;
	}

	/**
	 * Returns the legacy lecture series facility local service.
	 *
	 * @return the legacy lecture series facility local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalService getLegacyLectureSeriesFacilityLocalService() {
		return legacyLectureSeriesFacilityLocalService;
	}

	/**
	 * Sets the legacy lecture series facility local service.
	 *
	 * @param legacyLectureSeriesFacilityLocalService the legacy lecture series facility local service
	 */
	public void setLegacyLectureSeriesFacilityLocalService(
		de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalService legacyLectureSeriesFacilityLocalService) {
		this.legacyLectureSeriesFacilityLocalService = legacyLectureSeriesFacilityLocalService;
	}

	/**
	 * Returns the legacy lecture series facility persistence.
	 *
	 * @return the legacy lecture series facility persistence
	 */
	public LegacyLectureSeriesFacilityPersistence getLegacyLectureSeriesFacilityPersistence() {
		return legacyLectureSeriesFacilityPersistence;
	}

	/**
	 * Sets the legacy lecture series facility persistence.
	 *
	 * @param legacyLectureSeriesFacilityPersistence the legacy lecture series facility persistence
	 */
	public void setLegacyLectureSeriesFacilityPersistence(
		LegacyLectureSeriesFacilityPersistence legacyLectureSeriesFacilityPersistence) {
		this.legacyLectureSeriesFacilityPersistence = legacyLectureSeriesFacilityPersistence;
	}

	/**
	 * Returns the legacy metadata local service.
	 *
	 * @return the legacy metadata local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalService getLegacyMetadataLocalService() {
		return legacyMetadataLocalService;
	}

	/**
	 * Sets the legacy metadata local service.
	 *
	 * @param legacyMetadataLocalService the legacy metadata local service
	 */
	public void setLegacyMetadataLocalService(
		de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalService legacyMetadataLocalService) {
		this.legacyMetadataLocalService = legacyMetadataLocalService;
	}

	/**
	 * Returns the legacy metadata persistence.
	 *
	 * @return the legacy metadata persistence
	 */
	public LegacyMetadataPersistence getLegacyMetadataPersistence() {
		return legacyMetadataPersistence;
	}

	/**
	 * Sets the legacy metadata persistence.
	 *
	 * @param legacyMetadataPersistence the legacy metadata persistence
	 */
	public void setLegacyMetadataPersistence(
		LegacyMetadataPersistence legacyMetadataPersistence) {
		this.legacyMetadataPersistence = legacyMetadataPersistence;
	}

	/**
	 * Returns the legacy office local service.
	 *
	 * @return the legacy office local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalService getLegacyOfficeLocalService() {
		return legacyOfficeLocalService;
	}

	/**
	 * Sets the legacy office local service.
	 *
	 * @param legacyOfficeLocalService the legacy office local service
	 */
	public void setLegacyOfficeLocalService(
		de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalService legacyOfficeLocalService) {
		this.legacyOfficeLocalService = legacyOfficeLocalService;
	}

	/**
	 * Returns the legacy office persistence.
	 *
	 * @return the legacy office persistence
	 */
	public LegacyOfficePersistence getLegacyOfficePersistence() {
		return legacyOfficePersistence;
	}

	/**
	 * Sets the legacy office persistence.
	 *
	 * @param legacyOfficePersistence the legacy office persistence
	 */
	public void setLegacyOfficePersistence(
		LegacyOfficePersistence legacyOfficePersistence) {
		this.legacyOfficePersistence = legacyOfficePersistence;
	}

	/**
	 * Returns the legacy segment local service.
	 *
	 * @return the legacy segment local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacySegmentLocalService getLegacySegmentLocalService() {
		return legacySegmentLocalService;
	}

	/**
	 * Sets the legacy segment local service.
	 *
	 * @param legacySegmentLocalService the legacy segment local service
	 */
	public void setLegacySegmentLocalService(
		de.uhh.l2g.plugins.migration.service.LegacySegmentLocalService legacySegmentLocalService) {
		this.legacySegmentLocalService = legacySegmentLocalService;
	}

	/**
	 * Returns the legacy segment persistence.
	 *
	 * @return the legacy segment persistence
	 */
	public LegacySegmentPersistence getLegacySegmentPersistence() {
		return legacySegmentPersistence;
	}

	/**
	 * Sets the legacy segment persistence.
	 *
	 * @param legacySegmentPersistence the legacy segment persistence
	 */
	public void setLegacySegmentPersistence(
		LegacySegmentPersistence legacySegmentPersistence) {
		this.legacySegmentPersistence = legacySegmentPersistence;
	}

	/**
	 * Returns the legacy user local service.
	 *
	 * @return the legacy user local service
	 */
	public de.uhh.l2g.plugins.migration.service.LegacyUserLocalService getLegacyUserLocalService() {
		return legacyUserLocalService;
	}

	/**
	 * Sets the legacy user local service.
	 *
	 * @param legacyUserLocalService the legacy user local service
	 */
	public void setLegacyUserLocalService(
		de.uhh.l2g.plugins.migration.service.LegacyUserLocalService legacyUserLocalService) {
		this.legacyUserLocalService = legacyUserLocalService;
	}

	/**
	 * Returns the legacy user persistence.
	 *
	 * @return the legacy user persistence
	 */
	public LegacyUserPersistence getLegacyUserPersistence() {
		return legacyUserPersistence;
	}

	/**
	 * Sets the legacy user persistence.
	 *
	 * @param legacyUserPersistence the legacy user persistence
	 */
	public void setLegacyUserPersistence(
		LegacyUserPersistence legacyUserPersistence) {
		this.legacyUserPersistence = legacyUserPersistence;
	}

	/**
	 * Returns the test entity two local service.
	 *
	 * @return the test entity two local service
	 */
	public de.uhh.l2g.plugins.migration.service.TestEntityTwoLocalService getTestEntityTwoLocalService() {
		return testEntityTwoLocalService;
	}

	/**
	 * Sets the test entity two local service.
	 *
	 * @param testEntityTwoLocalService the test entity two local service
	 */
	public void setTestEntityTwoLocalService(
		de.uhh.l2g.plugins.migration.service.TestEntityTwoLocalService testEntityTwoLocalService) {
		this.testEntityTwoLocalService = testEntityTwoLocalService;
	}

	/**
	 * Returns the test entity two persistence.
	 *
	 * @return the test entity two persistence
	 */
	public TestEntityTwoPersistence getTestEntityTwoPersistence() {
		return testEntityTwoPersistence;
	}

	/**
	 * Sets the test entity two persistence.
	 *
	 * @param testEntityTwoPersistence the test entity two persistence
	 */
	public void setTestEntityTwoPersistence(
		TestEntityTwoPersistence testEntityTwoPersistence) {
		this.testEntityTwoPersistence = testEntityTwoPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("de.uhh.l2g.plugins.migration.model.LegacyMetadata",
			legacyMetadataLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"de.uhh.l2g.plugins.migration.model.LegacyMetadata");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return LegacyMetadata.class;
	}

	protected String getModelClassName() {
		return LegacyMetadata.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = legacyMetadataPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacyContactLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacyContactLocalService legacyContactLocalService;
	@BeanReference(type = LegacyContactPersistence.class)
	protected LegacyContactPersistence legacyContactPersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacyLectureSeriesFacilityLocalService legacyLectureSeriesFacilityLocalService;
	@BeanReference(type = LegacyLectureSeriesFacilityPersistence.class)
	protected LegacyLectureSeriesFacilityPersistence legacyLectureSeriesFacilityPersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacyMetadataLocalService legacyMetadataLocalService;
	@BeanReference(type = LegacyMetadataPersistence.class)
	protected LegacyMetadataPersistence legacyMetadataPersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacyOfficeLocalService legacyOfficeLocalService;
	@BeanReference(type = LegacyOfficePersistence.class)
	protected LegacyOfficePersistence legacyOfficePersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacySegmentLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacySegmentLocalService legacySegmentLocalService;
	@BeanReference(type = LegacySegmentPersistence.class)
	protected LegacySegmentPersistence legacySegmentPersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.LegacyUserLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.LegacyUserLocalService legacyUserLocalService;
	@BeanReference(type = LegacyUserPersistence.class)
	protected LegacyUserPersistence legacyUserPersistence;
	@BeanReference(type = de.uhh.l2g.plugins.migration.service.TestEntityTwoLocalService.class)
	protected de.uhh.l2g.plugins.migration.service.TestEntityTwoLocalService testEntityTwoLocalService;
	@BeanReference(type = TestEntityTwoPersistence.class)
	protected TestEntityTwoPersistence testEntityTwoPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private LegacyMetadataLocalServiceClpInvoker _clpInvoker = new LegacyMetadataLocalServiceClpInvoker();
}