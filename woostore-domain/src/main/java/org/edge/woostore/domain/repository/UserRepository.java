package org.edge.woostore.domain.repository;

import org.edge.woostore.domain.entity.Master;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/3/29.
 */
public interface UserRepository extends CrudRepository<Master, Long> {
    public Master findByUsername(String username);
}
