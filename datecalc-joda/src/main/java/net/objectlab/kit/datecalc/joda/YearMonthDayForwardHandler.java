/*
 * $Id$
 * 
 * Copyright 2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package net.objectlab.kit.datecalc.joda;

import net.objectlab.kit.datecalc.common.DateCalculator;
import net.objectlab.kit.datecalc.common.HolidayHandler;
import net.objectlab.kit.datecalc.common.HolidayHandlerType;

import org.joda.time.YearMonthDay;

/**
 * A Forward handler will move the date forward if it falls on a non working
 * day.
 * 
 * @author Benoit Xhenseval
 */
public class YearMonthDayForwardHandler implements HolidayHandler<YearMonthDay> {

    public YearMonthDay moveCurrentDate(final DateCalculator<YearMonthDay> calendar) {
        YearMonthDay date = calendar.getCurrentBusinessDate();
        while (calendar.isNonWorkingDay(date)) {
            date = date.plusDays(1);
        }
        return date;
    }

    public String getType() {
        return HolidayHandlerType.FORWARD;
    }
}
