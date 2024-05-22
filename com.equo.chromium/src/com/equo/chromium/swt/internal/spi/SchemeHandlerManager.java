/****************************************************************************
**
** Copyright (C) 2024 Equo
**
** This file is part of Equo Chromium.
**
** Commercial License Usage
** Licensees holding valid commercial Equo licenses may use this file in
** accordance with the commercial license agreement provided with the
** Software or, alternatively, in accordance with the terms contained in
** a written agreement between you and Equo. For licensing terms
** and conditions see https://www.equo.dev/terms.
**
** GNU General Public License Usage
** Alternatively, this file may be used under the terms of the GNU
** General Public License version 3 as published by the Free Software
** Foundation. Please review the following
** information to ensure the GNU General Public License requirements will
** be met: https://www.gnu.org/licenses/gpl-3.0.html.
**
****************************************************************************/


package com.equo.chromium.swt.internal.spi;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

public interface SchemeHandlerManager {

	public List<SchemeDomainPair> getRegisteredSchemes();

	public SchemeHandler getSchemeHandler(String scheme, String domain);

	public static SchemeHandlerManager get() {
		ServiceLoader<SchemeHandlerManager> serviceLoader = ServiceLoader.load(SchemeHandlerManager.class,
				SchemeHandlerManager.class.getClassLoader());
		Iterator<SchemeHandlerManager> it = serviceLoader.iterator();
		if (it.hasNext()) {
			return it.next();
		}
		return null;
	}

}
