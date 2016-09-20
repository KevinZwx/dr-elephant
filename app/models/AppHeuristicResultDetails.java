/*
 * Copyright 2016 LinkedIn Corp.
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

package models;

import com.avaje.ebean.annotation.ConcurrencyMode;
import com.avaje.ebean.annotation.EntityConcurrencyMode;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import play.db.ebean.Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


@Entity
@Table(name = "yarn_app_heuristic_result_details")
@EntityConcurrencyMode(ConcurrencyMode.NONE)
public class AppHeuristicResultDetails extends Model {

  private static final long serialVersionUID = 3L;

  public static final int NAME_LIMIT = 128;
  public static final int VALUE_LIMIT = 255;
  public static final int DETAILS_LIMIT = 65535;

  public static class TABLE {
    public static final String TABLE_NAME = "yarn_app_heuristic_result_details";
    public static final String APP_HEURISTIC_RESULT_ID = "yarnAppHeuristicResult";
    public static final String NAME = "name";
    public static final String VALUE = "value";
    public static final String DETAILS = "details";
//    public static final Timestamp LAST_UPDATE = Timestamp.valueOf("2016-09-14 17:57:06");
  }


  @JsonBackReference
  @ManyToOne(cascade = CascadeType.ALL)
  public AppHeuristicResult yarnAppHeuristicResult;

  @Column(length=NAME_LIMIT, nullable = false)
  public String name;

  @Column(length=VALUE_LIMIT, nullable = false)
  public String value;

  @Column(nullable = true)
  public String details;

//  @Version
//  @Column(columnDefinition = "timestamp default '2016-09-14 17:57:06'")
//  public Timestamp lastUpdate;

}
