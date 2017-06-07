/**
 * Let's say we have a table Events with 
 * (sensor_id:integer, event_type:integer, value:integer and time:timestamp).
 * I want an SQL for each sensor and event type return the most sum of events  <br/>
 * . The table should be sorted by sensor_id (asc).
 * 
 * result should be :
 * 
 * sensor_id  | event_type
 * -----------+------------
 *    2       | 3                                       
 *    3       | 1          
 */

SELECT distinct sensor_id ,count( event_type)
FROM (
  select sensor_id, event_type,
         row_number() over (partition by sensor_id, event_type) as rn
  from events 
) t
where rn = 1
GROUP BY sensor_id
ORDER BY sensor_id ASC