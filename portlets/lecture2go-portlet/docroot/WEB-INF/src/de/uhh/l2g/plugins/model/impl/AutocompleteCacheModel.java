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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.uhh.l2g.plugins.model.Autocomplete;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Autocomplete in entity cache.
 *
 * @author Iavor Sturm
 * @see Autocomplete
 * @generated
 */
public class AutocompleteCacheModel implements CacheModel<Autocomplete>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{autocompleteId=");
		sb.append(autocompleteId);
		sb.append(", searchWordsJson=");
		sb.append(searchWordsJson);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Autocomplete toEntityModel() {
		AutocompleteImpl autocompleteImpl = new AutocompleteImpl();

		autocompleteImpl.setAutocompleteId(autocompleteId);

		if (searchWordsJson == null) {
			autocompleteImpl.setSearchWordsJson(StringPool.BLANK);
		}
		else {
			autocompleteImpl.setSearchWordsJson(searchWordsJson);
		}

		autocompleteImpl.resetOriginalValues();

		return autocompleteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		autocompleteId = objectInput.readLong();
		searchWordsJson = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(autocompleteId);

		if (searchWordsJson == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchWordsJson);
		}
	}

	public long autocompleteId;
	public String searchWordsJson;
}