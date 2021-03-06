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

package de.uhh.l2g.plugins.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.uhh.l2g.plugins.model.InstallWizard;

/**
 * The persistence interface for the install wizard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see InstallWizardPersistenceImpl
 * @see InstallWizardUtil
 * @generated
 */
public interface InstallWizardPersistence extends BasePersistence<InstallWizard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstallWizardUtil} to access the install wizard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the install wizard where groupId = &#63; and companyId = &#63; or throws a {@link de.uhh.l2g.plugins.NoSuchInstallWizardException} if it could not be found.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching install wizard
	* @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a matching install wizard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard findBygroupAndCompyny(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstallWizardException;

	/**
	* Returns the install wizard where groupId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching install wizard, or <code>null</code> if a matching install wizard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard fetchBygroupAndCompyny(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the install wizard where groupId = &#63; and companyId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching install wizard, or <code>null</code> if a matching install wizard could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard fetchBygroupAndCompyny(
		long groupId, long companyId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the install wizard where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the install wizard that was removed
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard removeBygroupAndCompyny(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstallWizardException;

	/**
	* Returns the number of install wizards where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching install wizards
	* @throws SystemException if a system exception occurred
	*/
	public int countBygroupAndCompyny(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the install wizard in the entity cache if it is enabled.
	*
	* @param installWizard the install wizard
	*/
	public void cacheResult(
		de.uhh.l2g.plugins.model.InstallWizard installWizard);

	/**
	* Caches the install wizards in the entity cache if it is enabled.
	*
	* @param installWizards the install wizards
	*/
	public void cacheResult(
		java.util.List<de.uhh.l2g.plugins.model.InstallWizard> installWizards);

	/**
	* Creates a new install wizard with the primary key. Does not add the install wizard to the database.
	*
	* @param installWizardId the primary key for the new install wizard
	* @return the new install wizard
	*/
	public de.uhh.l2g.plugins.model.InstallWizard create(long installWizardId);

	/**
	* Removes the install wizard with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param installWizardId the primary key of the install wizard
	* @return the install wizard that was removed
	* @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard remove(long installWizardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstallWizardException;

	public de.uhh.l2g.plugins.model.InstallWizard updateImpl(
		de.uhh.l2g.plugins.model.InstallWizard installWizard)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the install wizard with the primary key or throws a {@link de.uhh.l2g.plugins.NoSuchInstallWizardException} if it could not be found.
	*
	* @param installWizardId the primary key of the install wizard
	* @return the install wizard
	* @throws de.uhh.l2g.plugins.NoSuchInstallWizardException if a install wizard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard findByPrimaryKey(
		long installWizardId)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.NoSuchInstallWizardException;

	/**
	* Returns the install wizard with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param installWizardId the primary key of the install wizard
	* @return the install wizard, or <code>null</code> if a install wizard with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public de.uhh.l2g.plugins.model.InstallWizard fetchByPrimaryKey(
		long installWizardId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the install wizards.
	*
	* @return the install wizards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.InstallWizard> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the install wizards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstallWizardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of install wizards
	* @param end the upper bound of the range of install wizards (not inclusive)
	* @return the range of install wizards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.InstallWizard> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the install wizards.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstallWizardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of install wizards
	* @param end the upper bound of the range of install wizards (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of install wizards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<de.uhh.l2g.plugins.model.InstallWizard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the install wizards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of install wizards.
	*
	* @return the number of install wizards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}