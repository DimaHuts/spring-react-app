package notebook.service.role.findRoleByPermissions;

import notebook.entity.Permission;
import notebook.entity.Role;

import java.util.Set;

public interface FindRoleByPermissionsService {
  Role findRoleByPermissions(Set<Permission> permissions);
}
